package org.dewOps.SingleResponsibility;

public class InvoiceDTO {
    Invoice invoice;
    InvoiceDTO(Invoice invoice){
        this.invoice=invoice;
    }
    public void saveToDB(){
        System.out.println("saving to db");
    }
}
