package org.dewOps.AbstractFactoryDesignPattern;

public class AbstractVehicalFactory {

    public VehicalFactory getVehicalFactory(String vehicalFactory){
        switch (vehicalFactory){
            case "ordinaryVehicalFactory":
                return new OrdinaryVehicalFactory();
            case "LuxVehicalFactory":
                return new LuxVehicalFactory();
            default:
                return null;
        }
    }
}
