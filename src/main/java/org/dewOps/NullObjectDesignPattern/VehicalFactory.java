package org.dewOps.NullObjectDesignPattern;

public class VehicalFactory {

    public Vehical getVehical(String vehical){
        switch (vehical){
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                return new NullVehical();
        }
    }
}
