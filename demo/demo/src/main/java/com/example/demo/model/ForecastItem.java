package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ForecastItem {
    // OpenWeather provides time as "dt_txt". This annotation maps it to a Java variable.
    @JsonProperty("dt_txt")
    private String dtTxt; 
    private MainData main;
    private List<WeatherDescription> weather;

    // Getters and Setters (Standard Java)
    public String getDtTxt() { return dtTxt; }
    public void setDtTxt(String dtTxt) { this.dtTxt = dtTxt; }
    public MainData getMain() { return main; }
    public void setMain(MainData main) { this.main = main; }
    public List<WeatherDescription> getWeather() { return weather; }
    public void setWeather(List<WeatherDescription> weather) { this.weather = weather; }

    // Inner class for temperature and humidity
    public static class MainData {
        private double temp;
        private int humidity;

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }

    // Inner class for text description (e.g. "clear sky", "rain")
    public static class WeatherDescription {
        private String description;
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}