package org.dewOps.NotifyMe;

public interface StockNotificationObserver {

    void update();
    String getNotificationMethod();
    String getUserId();
}
