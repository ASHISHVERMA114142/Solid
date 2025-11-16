package org.dewOps.ObserverDesignPattern;

public class ForecastDisplay implements WeatherObserver{
    private final WeatherObservable weatherObservable;
    ForecastDisplay(WeatherObservable weatherObservable){
        this.weatherObservable=weatherObservable;
        weatherObservable.addObserver(this);
    }
    @Override
    public void update() {
        System.out.println("update method inside the forecaseDisplay");
        display();
    }
    public void display(){
        System.out.println("we got this data from the the overservable : "+weatherObservable.toString());
    }
}
