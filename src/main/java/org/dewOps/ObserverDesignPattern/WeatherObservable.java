package org.dewOps.ObserverDesignPattern;

public interface WeatherObservable {

    void addObserver(WeatherObserver weatherObserver);
    void removeObserver(WeatherObserver weatherObserver);
    void notifyObserver();
    void setData(float tem,float humidity,float preassure);
}
