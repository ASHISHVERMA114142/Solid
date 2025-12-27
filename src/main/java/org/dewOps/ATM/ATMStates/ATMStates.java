package org.dewOps.ATM.ATMStates;

import org.dewOps.ATM.ATMRoomComponent.ATM;
import org.dewOps.ATM.ATMRoomComponent.Card;
import org.dewOps.ATM.enums.TransactionType;

public abstract class ATMStates {

        // idel state
    public void insertCard(ATM atm, Card card) {
        System.out.println("OPPS something went wrong here ");
    }
    // hasCardState
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("something went wrong while authenticatePin ");
    }
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println(" somethng went wrong at selectionOperation");
    }
    // cash-withdrawal-state,
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
        System.out.println("something went wrong while cashWithdrawal");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("something went wrong while displayBalance");
    }

    // hasCardState , cash-withdrawal-state,
    public void returnCard(){
        System.out.println("something went wrong while returnCard");
    }
    // hasCardState , cash-withdrawal-state,
    public void exit(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}
