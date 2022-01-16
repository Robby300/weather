package com.github.robby300.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "weather_history")
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHistory {

    @Column(name = "weather_date")
    @Id
    private LocalDate weatherDate;

    @Column(name = "weather_value")
    private String weatherValue;
}
