package ru.usernamedrew.kafkahometaskt1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDTO {
    private String city;
    private double temperature;
    private LocalDate date;
    private WeatherCondition condition;
}
