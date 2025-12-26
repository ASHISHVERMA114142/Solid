package org.dewOps.NullObjectDesignPattern;

public class Bike implements Vehical{
    @Override
    public int getTankCapacity() {
        return 5;
    }

    @Override
    public int getSeatingCapacity() {
        return 2;
    }
}
