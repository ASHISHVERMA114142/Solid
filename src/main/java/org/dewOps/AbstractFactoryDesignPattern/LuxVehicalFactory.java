package org.dewOps.AbstractFactoryDesignPattern;

public class LuxVehicalFactory implements VehicalFactory{
    @Override
    public Vehical getVehical(String vehical) {
        switch (vehical){
            case "BMW":
                return new BMW();
            case "RR":
                return new RR();
            default:
                return null;
        }
    }
}
