package com.github.robby300.weather.repo;

import com.github.robby300.weather.model.WeatherHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WeatherHistoryRepo extends CrudRepository<WeatherHistory, LocalDate> {
}
