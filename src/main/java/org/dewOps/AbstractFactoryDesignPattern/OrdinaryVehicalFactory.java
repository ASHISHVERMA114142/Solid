package org.dewOps.AbstractFactoryDesignPattern;

public class OrdinaryVehicalFactory implements VehicalFactory{
    @Override
    public Vehical getVehical(String vehical) {
        switch (vehical){
            case "swift" -> {
                return new Swift();
            }
            case "wagonR" -> {
                return new WagonR();
            }
            default -> {
                return null;
            }
        }
    }
}
