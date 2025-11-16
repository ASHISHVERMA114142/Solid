package org.dewOps.NotifyMe;

public class EmailNotificationObserver implements StockNotificationObserver{

    private final String userId;
    private final String emailAddress;
    EmailNotificationObserver(String userId,String emailAddress){
        this.userId=userId;
        this.emailAddress=emailAddress;
    }
    @Override
    public void update() {
        sendEmail();
    }
    void sendEmail(){
        System.out.println("sending email to user: "+this.userId + " on mail: "+this.emailAddress);
    }

    @Override
    public String getNotificationMethod() {
        return "Email";
    }

    @Override
    public String getUserId() {
        return this.userId;
    }
}
