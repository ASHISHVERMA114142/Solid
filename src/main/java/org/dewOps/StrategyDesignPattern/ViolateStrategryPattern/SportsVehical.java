package org.dewOps.StrategyDesignPattern.ViolateStrategryPattern;

public class SportsVehical extends Vehical{

    @Override
    public void drive(){
        System.out.println("Replacing the drive funtion from the vehical class "+this.getClass().getName());
        System.out.println("racing vehical");
    }
}
