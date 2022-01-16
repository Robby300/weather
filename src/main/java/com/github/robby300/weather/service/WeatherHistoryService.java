package com.github.robby300.weather.service;

import com.github.robby300.weather.repo.WeatherHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherHistoryService {
    private final WeatherHistoryRepo weatherHistoryRepo;

    @Autowired
    public WeatherHistoryService(WeatherHistoryRepo weatherHistoryRepo) {
        this.weatherHistoryRepo = weatherHistoryRepo;
    }
}
