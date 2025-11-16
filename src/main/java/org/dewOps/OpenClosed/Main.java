package org.dewOps.OpenClosed;


public class Main {
    public static void main(String[] args) {
        Marker marker=new Marker("camel","black",10,2023);
        Invoice invoice=new Invoice(marker,10);
        InvoiceInterface saveToDB=new InvoiceDaoDB(invoice);
        InvoiceInterface saveToFile=new InvoiceDaoFile(invoice);
        System.out.println(invoice.calculateTax());
        saveToFile.save();
        saveToDB.save();
    }
}
