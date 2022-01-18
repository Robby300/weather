package com.github.robby300.weather.service;

import com.github.robby300.weather.model.WeatherHistory;
import com.github.robby300.weather.repo.WeatherHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class WeatherHistoryService {
    private final WeatherHistoryRepo weatherHistoryRepo;

    @Autowired
    public WeatherHistoryService(WeatherHistoryRepo weatherHistoryRepo) {
        this.weatherHistoryRepo = weatherHistoryRepo;
    }

    public String getWeather() throws IOException, InterruptedException {
        Optional<WeatherHistory> weatherToday = weatherHistoryRepo.findById(LocalDate.now());
        String weather;
        if (weatherToday.isPresent()) {
            weather = weatherToday.get().getWeatherValue();
        } else {
            weather = getFromYandex();
            WeatherHistory weatherHistory = new WeatherHistory(LocalDate.now(), weather);
            weatherHistoryRepo.save(weatherHistory);
        }
        return weather;
    }

    public String getFromYandex() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(4))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://yandex.ru/"))
                .build();

        String response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
        int target = response.lastIndexOf("weather__temp'>");
        return response.substring(target + 15, response.indexOf("°"));

    }
}
