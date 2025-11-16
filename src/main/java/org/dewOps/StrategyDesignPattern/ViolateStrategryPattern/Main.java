package org.dewOps.StrategyDesignPattern.ViolateStrategryPattern;

public class Main {
    public static void main(String[] args) {
        Vehical sportsVehical=new SportsVehical();
        Vehical offRoadVehical=new OffRoadVehical();
        Vehical passangerVehical=new PassangerVehical();
        sportsVehical.drive();
        offRoadVehical.drive();
        passangerVehical.drive();
    }
}
