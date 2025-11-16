package org.dewOps.NotifyMe;

public interface StockAvailabilityObservable {

    void addStockObserver(StockNotificationObserver observer);
    void removeStockObserver(StockNotificationObserver observer);
    void notifyStockObserver();
    boolean purchase(int quantity);
    void restock(int quantity);
}
