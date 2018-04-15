package com.kosta.hotornot;

import com.softuni.hotornot.api.models.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServiceInterface {
    public static final String URL = "http://api.openweather.org/";

    @GET("data/2.5/weather?lat={}&lon={}?id=524901&APPID=43cb4b81af9fa01e4e056335ebe7f925")
    Call<CurrentWeather> getCurrentWeather(@Query("lat") double latitude, @Query("lon") double longitude);
}
