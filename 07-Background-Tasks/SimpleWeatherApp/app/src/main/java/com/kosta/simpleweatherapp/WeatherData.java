package com.kosta.simpleweatherapp;

/**
 * Created by Kostadin Kostadinov on 27/03/2018.
 */

public class WeatherData {
    private Weather[] weather;
    private Main main;
    class Main{
        public double temp;
        public double pressure;
    }
    class Weather{
        public String description;
    }

    public String getDescription(){
        return weather[0].description;
    }

    public double getTemp(){
        return main.temp;
    }

    public double getPressure(){
        return main.pressure;
    }


    @Override
    public String toString() {
        String res = "description: " + getDescription() + " temp: " + getTemp()
                + " pressure: " + getPressure()+ "\n";
        return res;
    }
}
