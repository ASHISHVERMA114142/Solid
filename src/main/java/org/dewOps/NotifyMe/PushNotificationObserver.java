package org.dewOps.NotifyMe;

public class PushNotificationObserver implements StockNotificationObserver{
    private final String userId;
    private final String deviceToken;
    PushNotificationObserver(String userId,String deviceToken){
        this.userId=userId;
        this.deviceToken=deviceToken;
    }
    @Override
    public void update() {
        sendPushNotification();
    }
    public void sendPushNotification(){
        System.out.println("Sending push notification to user: "+this.userId+" on deviceToken"+this.deviceToken);
    }

    @Override
    public String getNotificationMethod() {
        return "Notification";
    }

    @Override
    public String getUserId() {
        return this.userId;
    }
}
