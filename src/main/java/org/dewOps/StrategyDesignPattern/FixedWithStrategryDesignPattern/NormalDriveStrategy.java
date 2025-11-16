package org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern;

public class NormalDriveStrategy implements DriveStrategy{

    @Override
    public void drive(){
        System.out.println("NormalDriveStrategy");
    }
}
