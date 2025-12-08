package org.dewOps.AbstractFactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("AbstractFactoryDesignPattern");
        String vehicalFactor=  "LuxVehicalFactory";
        String vehical="RR";
        AbstractVehicalFactory abstractVehicalFactory=new AbstractVehicalFactory();
        VehicalFactory vehicalFactory= abstractVehicalFactory.getVehicalFactory(vehicalFactor);
        Vehical vehical1= vehicalFactory.getVehical(vehical);
        vehical1.drive();
        System.out.println("END of AbstractFactoryDesignPattern");
    }
}
