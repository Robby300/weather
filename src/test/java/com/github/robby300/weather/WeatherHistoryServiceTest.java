package com.github.robby300.weather;

import com.github.robby300.weather.service.WeatherHistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class WeatherHistoryServiceTest {

     @Autowired
    WeatherHistoryService weatherHistoryService;

    @Test
    void getWeather() {
        String test;
        try {
            test = weatherHistoryService.getFromYandex();
            assertTrue((test.contains("−") || test.contains("+")) && test.contains("°") );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}