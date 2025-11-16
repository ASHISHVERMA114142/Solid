package org.dewOps.NotifyMe;

import java.util.ArrayList;
import java.util.List;

public class IphoneProductObservable implements StockAvailabilityObservable{


    private String productId;
    private String productName;
    private double price;
    private List<StockNotificationObserver> stockNotificationObserversList;
    private int quantity;

    public IphoneProductObservable(String productId, String productName, double price,  int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockNotificationObserversList = new ArrayList<>();
        this.quantity = quantity;
    }

    @Override
    public void addStockObserver(StockNotificationObserver observer) {
//        System.out.println(observer.getUserId()+" "+observer.getClass().getSimpleName());
        stockNotificationObserversList.add(observer);
        System.out.println("[+]" + observer.getUserId() + " subscribed for notifications on " + productName);

    }

    @Override
    public void removeStockObserver(StockNotificationObserver observer) {
        stockNotificationObserversList.remove(observer);
        System.out.println("[-]" + observer.getUserId() + " unsubscribed for notifications on " + productName);

    }

    @Override
    public void notifyStockObserver() {
        if(this.quantity>0 && !stockNotificationObserversList.isEmpty()){
            System.out.println("Notifying " + stockNotificationObserversList.size() + " subscribers... ");

            List<StockNotificationObserver> list=new ArrayList<>(stockNotificationObserversList);
            for(StockNotificationObserver stockNotificationObserver: stockNotificationObserversList){
                stockNotificationObserver.update();
            }
        }
    }

    @Override
    public boolean purchase(int quantity) {
        if(this.quantity>=quantity){
            this.quantity-=quantity;
            System.out.println("PURCHASE SUCCESS: "+quantity+" units of : "+productName+" Remaining stock "+this.quantity);
            return true;
        }else{
            System.out.println("PURCHASE FAILED "+ quantity + " is higher then the avaliable product "+productName);
        }
        return false;
    }

    @Override
    public void restock(int quantity) {
        boolean wasStockAvaliable=(quantity==0);
        this.quantity+=quantity;
        if(!wasStockAvaliable && this.quantity>0){
            notifyStockObserver();
        }
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStockNotificationObserversList(List<StockNotificationObserver> stockNotificationObserversList) {
        this.stockNotificationObserversList = stockNotificationObserversList;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public List<StockNotificationObserver> getStockNotificationObserversList() {
        return stockNotificationObserversList;
    }

    public int getQuantity() {
        return quantity;
    }
}
