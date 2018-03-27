package com.kosta.simpleweatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kostadin Kostadinov on 27/03/2018.
 */

public interface WeatherServiceInterface {
    public static final String URL = "http://api.openweather.org/data/2.5/";

    @GET("data/2.5/weather?id=524901&APPID=43cb4b81af9fa01e4e056335ebe7f925")
    Call<WeatherData> getCurrentWeather (@Query("lat") double latitude, @Query("lon") double longitude);

}
