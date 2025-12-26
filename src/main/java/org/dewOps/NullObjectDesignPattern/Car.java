package org.dewOps.NullObjectDesignPattern;

public class Car implements Vehical{
    @Override
    public int getTankCapacity() {
        return 12;
    }

    @Override
    public int getSeatingCapacity() {
        return 5;
    }
}
