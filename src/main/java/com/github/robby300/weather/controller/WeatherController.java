package com.github.robby300.weather.controller;

import com.github.robby300.weather.service.WeatherHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherHistoryService weatherHistoryService;
    @Autowired
    public WeatherController(WeatherHistoryService weatherHistoryService) {
        this.weatherHistoryService = weatherHistoryService;
    }

    @GetMapping
    public String getWeather() throws IOException, InterruptedException {
        return weatherHistoryService.getWeather();
    }
}
