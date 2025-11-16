package org.dewOps.ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {

        WeatherObservable weatherStation=new WeatherStation();
        WeatherObserver currentlConditionDisplay=new CurrentConditionsDisplay(weatherStation);
        WeatherObserver foreCaseDisplay=new ForecastDisplay(weatherStation);

        weatherStation.setData(1.1f,1.2f,123.12f);
        weatherStation.setData(23f,233f,3223f);
        weatherStation.removeObserver(foreCaseDisplay);
        weatherStation.setData(12f,32f,32f);
    }
}
