package com.example.demo.model;

import java.util.List;

public class ForecastResponse {
    private City city;
    private List<ForecastItem> list;

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public List<ForecastItem> getList() { return list; }
    public void setList(List<ForecastItem> list) { this.list = list; }

    public static class City {
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}