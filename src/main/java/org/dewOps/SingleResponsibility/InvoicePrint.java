package org.dewOps.SingleResponsibility;

public class InvoicePrint {
    Invoice invoice;
    InvoicePrint(Invoice invoice){
        this.invoice=invoice;
    }
    public void printInvoide(){
        System.out.println("printing invoice");
    }
}
