# SAGA Design Pattern

## What is the SAGA Pattern?

In a microservices architecture, you often need to perform a **distributed transaction** — a sequence of operations that span multiple services. Traditional ACID transactions (with a single database and rollback) don't work across service boundaries. **SAGA is the solution.**

A SAGA is a sequence of **local transactions**. Each local transaction updates data within a single service and publishes an event or message to trigger the next step. If one step fails, the SAGA executes **compensating transactions** to undo the work done by preceding steps.

---

## Two Types of SAGA Coordination

### 1. Choreography

Services talk to each other via events — there is no central brain.

```
Order Service  →  [OrderCreated event]  →  Event Bus
Event Bus      →  [OrderCreated event]  →  Payment Service
Payment Service →  [PaymentDone event]  →  Event Bus
Event Bus      →  [PaymentDone event]  →  Inventory Service
Inventory Service → [StockReserved event] → Event Bus
Event Bus      →  [StockReserved event] →  Shipping Service
```

**Pros:**
- Simple to implement for small flows
- No single point of failure
- Services are fully decoupled

**Cons:**
- Hard to trace when something fails
- Circular dependencies can emerge accidentally
- No central view of saga progress

---

### 2. Orchestration

A dedicated **Orchestrator** (state machine) explicitly commands each service and handles all failure logic.

```
Orchestrator  →  [Command: ChargePayment]   →  Payment Service
Payment Service → [Reply: PaymentSuccess]  →  Orchestrator
Orchestrator  →  [Command: ReserveStock]   →  Inventory Service
Inventory Service → [Reply: StockReserved] →  Orchestrator
Orchestrator  →  [Command: ScheduleShip]   →  Shipping Service
```

**Pros:**
- Single source of truth for saga progress
- Easier to observe, debug, and test
- Explicit failure handling and branching logic

**Cons:**
- Orchestrator is a new service to build and maintain
- Can become a bottleneck if not designed well

---

## Why Do We Need SAGA?

Traditional **2-Phase Commit (2PC)** across microservices is impractical:

| Problem | Why It Matters |
|---|---|
| Distributed locks | 2PC locks rows across services for the full duration, killing throughput |
| Coordinator bottleneck | If the 2PC coordinator crashes, all participants are stuck |
| Tight coupling | Services share transactional context, breaking autonomy |
| No shared DB | Each microservice owns its own database — `BEGIN TRANSACTION` across two DBs is not possible |

SAGA solves this by trading strict ACID for **eventual consistency** using local transactions + compensating transactions.

---

## Key Concepts

### Compensating Transaction

The "undo" operation for a step that already committed locally.

**Example:**
1. Order SAGA starts
2. Payment Service charges card ✅ (committed)
3. Inventory Service fails to reserve stock ❌
4. Compensating transaction: **Refund the payment**

> Compensating transactions must be **idempotent** — they may be retried multiple times due to network failures or crashes.

---

### Isolation Problem (Dirty Reads)

Since each step commits locally, other requests can observe intermediate states. For example, another service might see an order as `PAYMENT_DONE` before inventory is confirmed.

**Mitigation strategies:**
- **Semantic locks** — mark records as `PENDING` until the saga completes
- **Pessimistic ordering** — design UIs to surface only terminal states
- **Read-your-writes consistency** — route reads to the saga orchestrator

---

### Idempotency

Every step and compensating transaction must be safe to retry.

**Implementation approaches:**
- Store an idempotency key (UUID) per saga step in the DB
- Check for duplicate event IDs before processing
- Use exactly-once or at-least-once delivery semantics appropriately

---

### Saga State Persistence

The orchestrator persists a `saga_state` record for every in-flight saga.

```
saga_id  | step              | status
---------|-------------------|------------
abc-123  | PAYMENT           | COMPLETED
abc-123  | INVENTORY         | COMPENSATING
abc-123  | REFUND_PAYMENT    | STARTED
```

On crash recovery, the orchestrator re-reads the saga log and resumes from the last known good step.

---

### The Outbox Pattern (Critical for SAGAs)

**Problem:** You update your DB and then publish a Kafka/RabbitMQ event. If the app crashes between those two operations, the event is lost — a **dual-write problem**.

**Solution:** Write the event to an `outbox` table in the **same local DB transaction**, then a separate relay process publishes it to the message broker.

```
Application:
  BEGIN TRANSACTION
    UPDATE orders SET status = 'PAYMENT_DONE'
    INSERT INTO outbox (event_type, payload) VALUES ('PaymentDone', {...})
  COMMIT

Relay process (Debezium / CDC / polling loop):
  reads outbox table → publishes to Kafka → marks outbox row as published
```

This makes event publishing **atomic with the DB write** — no lost events even on crash.

---

## Choreography vs Orchestration — When to Pick Each

| Factor | Choreography | Orchestration |
|---|---|---|
| Flow complexity | Simple, linear (2–3 services) | Complex, with branching/conditions |
| Observability | Hard — traces span multiple logs | Easy — orchestrator is the single source |
| Error handling | Distributed, harder to manage | Centralised in the orchestrator |
| Service coupling | Loose (event contracts) | Loose (command/reply) |
| Production scale | Gets messy at scale | Preferred for business-critical flows |

> Most production systems at scale (Netflix, Uber) converge on **orchestration** for business-critical flows.

---

## SAGA in Spring Boot

You can implement SAGAs using:

- **Axon Framework** — dedicated SAGA support with event sourcing built in
- **Spring State Machine + Kafka/RabbitMQ** — manual implementation

### Typical architecture:

```
┌─────────────────────────────────┐
│  Orchestrator Service           │
│  - Spring State Machine         │
│  - Saga state in PostgreSQL     │
│  - Publishes commands to Kafka  │
└────────────┬────────────────────┘
             │ Commands (Kafka)
    ┌────────▼────────┐   ┌─────────────────┐
    │ Payment Service │   │ Inventory Service│
    │ @Transactional  │   │ @Transactional   │
    │ + Outbox table  │   │ + Outbox table   │
    └────────┬────────┘   └────────┬─────────┘
             │ Reply events (Kafka)│
             └─────────┬───────────┘
                       ▼
              Back to Orchestrator
```

---

## Interview Questions & Answers

### Fundamentals

**Q: What is a SAGA, and how is it different from 2-phase commit?**

2PC uses a coordinator to lock resources across all participants before committing — it's synchronous, tightly coupled, and fails badly if the coordinator crashes. SAGA breaks the transaction into independent local steps; each step commits immediately and publishes an event. On failure, it runs pre-defined compensating transactions. SAGA sacrifices isolation (intermediate states are visible) in exchange for availability and loose coupling.

---

**Q: What are the two types of SAGA coordination?**

Choreography — each service reacts to events from the previous step; no central coordinator. Simple to implement, but hard to trace at scale and circular dependencies can emerge.

Orchestration — a dedicated orchestrator (state machine) explicitly commands each service and handles failure logic. Easier to observe and debug, but introduces a new service to maintain.

---

**Q: What is a compensating transaction? Give an example.**

It's the "undo" operation for a step that already committed locally. If an order SAGA completes Payment but then Inventory reservation fails, the compensating transaction for Payment is a Refund. Compensating transactions must be idempotent — they may be retried multiple times.

---

### Intermediate

**Q: What is the isolation problem in SAGAs?**

Since each step commits locally, another request can read intermediate state — e.g. seeing an order as `PAYMENT_DONE` before inventory is confirmed. This violates ACID isolation. Mitigation: semantic locks, pessimistic ordering, or designing UIs to surface only terminal states.

---

**Q: How do you handle idempotency in SAGAs?**

Every step and compensating transaction must be idempotent because the orchestrator may retry on failure. Approaches: idempotency keys (UUID per saga step stored in the DB), deduplication checks before processing, and using appropriate message delivery semantics (at-least-once with dedup, or exactly-once).

---

**Q: How do you track SAGA state?**

The orchestrator persists a `saga_state` table (step, status: STARTED / COMPLETED / COMPENSATING / FAILED). Each step transition is written to the DB before the command is sent. On crash recovery, the orchestrator re-reads the state and resumes from the last confirmed step.

---

**Q: What happens if the orchestrator itself crashes mid-SAGA?**

Saga state must be persisted durably before sending commands. On restart, the orchestrator re-reads the saga log and replays from the last confirmed step. This is why the Outbox Pattern is critical — write to the DB and to the outbox atomically; a relay process publishes it to the broker independently.

---

### Advanced / Senior-Level

**Q: What is the Outbox Pattern, and why is it critical for SAGAs?**

Without it, you have a dual-write problem: update your DB and then publish to Kafka. If the app crashes in between, the event is lost. The Outbox Pattern writes the event to an `outbox` table in the same local DB transaction, then a separate relay (Debezium, CDC, or a polling loop) publishes it to the broker. This makes event publishing atomic with the DB write.

---

**Q: Choreography vs Orchestration — when would you pick each?**

Choreography works well for simple linear flows with 2–3 services and stable event contracts. It falls apart at scale: debugging requires tracing events across multiple service logs, and circular dependencies can emerge accidentally.

Orchestration is preferred for complex flows, error handling with branching logic, and systems where observability matters. The orchestrator is a single source of truth for the saga's progress. Most production systems at scale converge on orchestration for business-critical flows.

---

**Q: How would you implement SAGA in a Spring Boot system?**

Use Axon Framework (dedicated SAGA support with event sourcing) or build it manually with Spring State Machine + Kafka/RabbitMQ. The orchestrator is a Spring service that maintains saga state in a DB and publishes commands via a message broker. Each service listens for commands, executes locally, and publishes result events back. Spring's `@Transactional` + Outbox table handles the atomic write + publish problem.

---

**Q: What are the main challenges of SAGAs in production?**

- **Partial failures & compensation complexity** — compensating transactions must handle cases where the target service is also down
- **Observability** — you need distributed tracing (Jaeger, Zipkin) across all steps
- **Schema evolution** — changing event formats breaks choreography consumers
- **Testing** — simulating mid-saga failures requires chaos tooling or careful integration test setup
- **Ordering guarantees** — Kafka partitioning must be set up carefully to preserve event order per saga instance

---

## Quick Reference Cheat Sheet

| Concept | One-liner |
|---|---|
| SAGA | Sequence of local transactions with compensating rollbacks |
| Choreography | Services react to each other's events — no central brain |
| Orchestration | Central coordinator commands each step explicitly |
| Compensating transaction | The "undo" of a committed local step |
| Outbox Pattern | Write event to DB atomically; relay publishes it to broker |
| Idempotency | Safe to retry — same input always produces same result |
| Isolation problem | Intermediate saga states are visible to other requests |
| Semantic lock | Mark record as PENDING to prevent dirty reads mid-saga |
