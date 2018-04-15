package com.kosta.hotornot.RecycleViewClasses;

public class WeatherCard {

    private String date;
    private String weather;
    private String cloudsProcent;
    private String windSpeed;
    private String humidityProcent;
    private String temperature;
    private String range;
    private String description;

    public WeatherCard() {
    }

    public WeatherCard(String data, String weather, String cloudsProcent, String windSpeed, String humidityProcent,
                       String temperature, String range, String description) {
        this.date = date;
        this.weather = weather;
        this.cloudsProcent = cloudsProcent;
        this.windSpeed = windSpeed;
        this.humidityProcent = humidityProcent;
        this.temperature = temperature;
        this.range = range;
        this.description = description;

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

    public String getCloudsProcent() {
        return cloudsProcent;
    }

    public void setCloudsProcent(String cloudsProcent) {
        this.cloudsProcent = cloudsProcent;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidityProcent() {
        return humidityProcent;
    }

    public void setHumidityProcent(String humidityProcent) {
        this.humidityProcent = humidityProcent;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
