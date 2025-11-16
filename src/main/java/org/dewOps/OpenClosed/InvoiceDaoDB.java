package org.dewOps.OpenClosed;

public class InvoiceDaoDB implements InvoiceInterface{
    Invoice invoice;
    InvoiceDaoDB(Invoice invoice){
        this.invoice=invoice;
    }
    @Override
    public void save(){
        System.out.println("saving to db");
    }
}
