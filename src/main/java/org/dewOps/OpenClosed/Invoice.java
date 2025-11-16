package org.dewOps.OpenClosed;



public class Invoice {

        Marker marker;
        int quantiy;
        int price;
    Invoice(Marker marker, int quantiy){
        this.marker=marker;
        this.quantiy=quantiy;
    }
    public int calculateTax(){
        return this.marker.getPrice()*this.quantiy;
    }
}
