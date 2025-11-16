package org.dewOps.SingleResponsibility;

public class InvoiceOld {
    private Marker marker;
    private int quantity;
    private int total;
    InvoiceOld(Marker marker, int quantity){
        this.marker=marker;
        this.quantity=quantity;
    }
    public int calculateTotal(){
        System.out.println("calculateTotal method");
        return this.marker.getPrice()*this.quantity;
    }
    public void saveToDB(){
        System.out.println("saving to db");
    }
    public void printInvoice(){
        System.out.println("printing invoice ");
    }
}
