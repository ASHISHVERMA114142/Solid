package org.dewOps.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable{

    List<WeatherObserver> weatherObserverList ;
    float temp;
    float humidity;
    float preassure;
    WeatherStation(){
        this.weatherObserverList=new ArrayList<>();
    }
    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        weatherObserverList.add(weatherObserver);
        System.out.println("[+] Observer registered: " + weatherObserver.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        weatherObserverList.remove(weatherObserver);
        System.out.println("[+] Observer removed: "+ weatherObserver.getClass().getSimpleName());
    }
    @Override
    public void notifyObserver() {
        for(WeatherObserver weatherObserver:weatherObserverList){
            weatherObserver.update();
        }
    }

    @Override
    public void setData(float tem, float humidity, float preassure) {
        this.temp=tem;
        this.humidity=humidity;
        this.preassure=preassure;
        this.notifyObserver();
    }

    public List<WeatherObserver> getWeatherObserverList() {
        return weatherObserverList;
    }

    public void setWeatherObserverList(List<WeatherObserver> weatherObserverList) {
        this.weatherObserverList = weatherObserverList;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPreassure(float preassure) {
        this.preassure = preassure;
    }

    public float getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", preassure=" + preassure +
                '}';
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPreassure() {
        return preassure;
    }


}
