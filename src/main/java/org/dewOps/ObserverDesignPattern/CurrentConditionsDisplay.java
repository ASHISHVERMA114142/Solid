package org.dewOps.ObserverDesignPattern;

public class CurrentConditionsDisplay implements WeatherObserver{
    private final WeatherObservable weatherObservable;

    public CurrentConditionsDisplay(WeatherObservable weatherObservable) {
        this.weatherObservable = weatherObservable;
        weatherObservable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("saving the weather data");
        display();
    }
    public void display(){
        System.out.println("current weather condition : "+weatherObservable.toString());
    }
}
