package org.dewOps.StrategyDesignPattern.ViolateStrategryPattern;

public class OffRoadVehical extends Vehical{
    @Override
    public void drive(){
        System.out.println("Replacing the vehical drive method "+this.getClass().getName());
    }
}
