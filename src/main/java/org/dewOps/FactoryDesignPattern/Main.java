package org.dewOps.FactoryDesignPattern;

import org.dewOps.StrategyDesignPattern.FixedWithStrategryDesignPattern.Vehical;

public class Main {
    public static void main(String[] args) {
        System.out.println("Factory Design pattern ");
        ShapreFactory shapreFactory=new ShapreFactory();
        String shapre="circle";
        Shape shape= shapreFactory.getShape(shapre);
        shape.draw();
        System.out.println("END OF Factory Design Pattern");
    }
}
