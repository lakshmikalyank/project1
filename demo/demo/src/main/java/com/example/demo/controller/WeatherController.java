package com.example.demo.controller;

import com.example.demo.model.ForecastResponse;
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    // Spring Boot automatically passes our WeatherService into this constructor!
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Listens for when someone just opens the homepage (http://localhost:8080/)
    @GetMapping("/")
    public String index() {
        return "index"; // Looks for a template named "index.html"
    }

    // Listens for when someone submits the search form (e.g., /weather?city=Paris)
    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        ForecastResponse forecast = weatherService.get5DayForecast(city);
        
        if (forecast != null && !forecast.getList().isEmpty()) {
            // Model acts like a bridge. We load Java data into it so the HTML can read it.
            model.addAttribute("cityName", forecast.getCity().getName());
            model.addAttribute("forecastList", forecast.getList());
        } else {
            model.addAttribute("error", "City not found. Please try again!");
        }
        
        return "index"; // Refreshes index.html with the new data loaded
    }
}