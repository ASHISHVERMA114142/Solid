package org.dewOps.OpenClosed;

public class InvoiceDaoFile implements InvoiceInterface{

    Invoice invoice;
    InvoiceDaoFile(Invoice invoice){
        this.invoice=invoice;
    }
    @Override
    public void save(){
        System.out.println("saving to file");
    }
}
