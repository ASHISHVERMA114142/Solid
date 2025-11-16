package org.dewOps.NotifyMe;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("###### E-commerce Store - StockAvailability Notification Feature Demo ######");
        StockAvailabilityObservable iphoneProduct = new IphoneProductObservable("ip15", "iphone 15", 1250, 10);
        StockNotificationObserver John_PUSH = new PushNotificationObserver("John123", "JohnDeviceP1");
        StockNotificationObserver Katy_PUSH = new PushNotificationObserver("Katy678", "KatyDeviceP2");
        StockNotificationObserver Jane_EMAIL = new EmailNotificationObserver("Jane783", "jane783@gmail.com");
        StockNotificationObserver George_EMAIL = new EmailNotificationObserver("George993", "george993@gmail.com");

        iphoneProduct.purchase(10);

        boolean success = iphoneProduct.purchase(1);
        if(!success){
            iphoneProduct.addStockObserver(Katy_PUSH);
            iphoneProduct.addStockObserver(John_PUSH);
            iphoneProduct.addStockObserver(Jane_EMAIL);
            iphoneProduct.addStockObserver(George_EMAIL);

        }
        iphoneProduct.restock(20);
        iphoneProduct.purchase(1);
        iphoneProduct.purchase(1);
        iphoneProduct.removeStockObserver(John_PUSH);
        iphoneProduct.removeStockObserver(Katy_PUSH);
        iphoneProduct.purchase(18);
        iphoneProduct.restock(5);
        iphoneProduct.purchase(3);
        iphoneProduct.purchase(2);
        iphoneProduct.removeStockObserver(Jane_EMAIL);
        iphoneProduct.removeStockObserver(George_EMAIL);
        iphoneProduct.restock(5);



    }
}
