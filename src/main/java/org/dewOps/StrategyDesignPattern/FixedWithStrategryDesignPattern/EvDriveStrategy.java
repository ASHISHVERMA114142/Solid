package org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern;

public class EvDriveStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("EvDriveStrategy");
    }
}
