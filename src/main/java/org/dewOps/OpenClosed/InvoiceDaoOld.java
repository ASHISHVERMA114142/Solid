package org.dewOps.OpenClosed;

public class InvoiceDaoOld {
    Invoice invoice;
    InvoiceDaoOld(Invoice invoice){
        this.invoice=invoice;
    }
    public void saveToDB(){
        System.out.println("saving to DB");
    }
    public void saveTofile(){
        System.out.println("saving to file");
    }
}
