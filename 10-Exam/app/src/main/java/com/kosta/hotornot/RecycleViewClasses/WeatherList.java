package com.kosta.hotornot.RecycleViewClasses;

import java.util.Arrays;
import java.util.List;

public class WeatherList {
    public static List<WeatherCard> database;

    public static List<WeatherCard> getData() {
        if (database == null) database = setDatabase();
        return database;
    }

    public static List<WeatherCard> setDatabase() {
        return Arrays.asList(
                new WeatherCard("Today 12/03/2014", "Rain", "67%", "4 m/s", "33 %", "10C", "10-13", "strong")
        );

    }

}
