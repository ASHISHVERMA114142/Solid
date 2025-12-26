package org.dewOps.NullObjectDesignPattern;


/**
 * 1. replaces null type by the null object
 * 2. no need to put null check for the null values .
 * 3. null object reflects the default values or do nothing behaviour
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("NullObjectDesignPattern");
        VehicalFactory vehicalFactory = new VehicalFactory();
        Vehical vehical = vehicalFactory.getVehical("car4");
        System.out.println(vehical.getTankCapacity());
        System.out.println(vehical.getSeatingCapacity());
        System.out.println("END of NullObjectDesignPattern");
    }
}
