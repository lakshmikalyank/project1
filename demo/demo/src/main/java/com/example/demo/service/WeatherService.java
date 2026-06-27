package com.example.demo.service;

import com.example.demo.model.ForecastResponse;
import com.example.demo.model.ForecastItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    // These pull the variables we saved in application.properties earlier
    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.forecast.url}")
    private String forecastUrl;

    // RestTemplate is a built-in Spring tool used to make HTTP/web requests
    private final RestTemplate restTemplate = new RestTemplate();

    public ForecastResponse get5DayForecast(String city) {
        // units=metric changes temperatures from Kelvin to Celsius
        String url = String.format("%s?q=%s&appid=%s&units=metric", forecastUrl, city, apiKey);
        
        try {
            // This single line hits the web URL and perfectly maps the JSON text into our Java Object!
            ForecastResponse response = restTemplate.getForObject(url, ForecastResponse.class);
            
            if (response != null && response.getList() != null) {
                // The API gives data points every 3 hours. We use standard Java Streams 
                // to filter and only keep entries from noon (12:00) so we get 1 clean entry per day.
                List<ForecastItem> dailyForecast = response.getList().stream()
                        .filter(item -> item.getDtTxt().contains("12:00:00"))
                        .collect(Collectors.toList());
                
                response.setList(dailyForecast);
            }
            return response;
        } catch (Exception e) {
            return null; // Returns null if the city doesn't exist or network fails
        }
    }
}