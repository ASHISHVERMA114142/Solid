package org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern;

public class Vehical {
    public DriveStrategy driveStrategy;
    Vehical(DriveStrategy driveStrategy){
        this.driveStrategy=driveStrategy;
    }
    public void drive(){
        System.out.println("class name "+ this.getClass().getSimpleName());
        driveStrategy.drive();
    }
}
