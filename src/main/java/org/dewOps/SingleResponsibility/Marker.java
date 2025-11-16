package org.dewOps.SingleResponsibility;

public class Marker {
    private String name;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    private String color;
    private int price;
    private int year;
    Marker(String name,String color,int price,int year){
        this.name=name;
        this.color=color;
        this.price=price;
        this.year=year;
    }
}
