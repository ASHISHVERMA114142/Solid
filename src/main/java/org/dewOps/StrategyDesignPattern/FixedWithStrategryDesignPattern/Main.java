package org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern;



public class Main {
    public static void main(String[] args) {
        System.out.println("###### Strategy Design Pattern ######");
        System.out.println("###### Example: Vehicle Drive Mode ######");
        Vehical sportsVehical=new SportsVehical(new SportsDriveStrategy());
        Vehical offRoadVehical=new OffRoadVehical(new SportsDriveStrategy());
        PassangerVehical normalVehical=new PassangerVehical(new NormalDriveStrategy());
        Vehical hybrideVehical=new HybrideVehical(new SportsDriveStrategy());

        sportsVehical.drive();
        offRoadVehical.drive();
        normalVehical.drive();
        hybrideVehical.drive();
    }
}
