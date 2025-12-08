package org.dewOps.FactoryDesignPattern;

import org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern.Vehical;

public class ShapreFactory {

    public Shape getShape(String shape){
        switch (shape){
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
