package com.github.robby300.weather.repo;

import com.github.robby300.weather.model.WeatherHistory;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface WeatherHistoryRepo extends CrudRepository<WeatherHistory, LocalDate> {
}
