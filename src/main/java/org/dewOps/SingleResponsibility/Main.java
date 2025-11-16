package org.dewOps.SingleResponsibility;


//
// "A class should have only one reason to changes " meaning it should have ONE and ONLY ONE job or responsibility.
// Meaning, if the class has multiple jobs or responsibilities, changes to one responsibility might affect or break the
//other critical responsibilities, making the code bloated, fragile, and harder to maintain. Hence, the Single
//Responsibility Principle(SRP) focuses on restricting the concern to only a single responsibility
public class Main {
    public static void main(String[] args) {
        Marker marker=new Marker("camel","black",10,2023);
//        InvoiceOld invoiceOld =new InvoiceOld(marker,10);
//        System.out.println(invoiceOld.calculateTotal());
//        invoiceOld.saveToDB();
//        invoiceOld.printInvoice();
        Invoice invoice=new Invoice(marker,10);
        InvoiceDTO invoiceDTO=new InvoiceDTO(invoice);
        InvoicePrint invoicePrint=new InvoicePrint(invoice);
        System.out.println("calculateTotal "+invoice.calculateTax());
        invoiceDTO.saveToDB();
        invoicePrint.printInvoide();

    }
}
