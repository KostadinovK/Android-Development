package com.kosta.hotornot.RecycleViewClasses;

public class DetailCard {
    private String date;
    private String weather;
    private String description;
    private String temperature;

    public DetailCard() {
    }

    public DetailCard(String date, String weather, String description, String temperature) {
        this.date = date;
        this.weather = weather;
        this.description = description;
        this.temperature = temperature;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
