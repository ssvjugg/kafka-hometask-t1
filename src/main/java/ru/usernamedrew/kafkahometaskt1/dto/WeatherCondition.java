package ru.usernamedrew.kafkahometaskt1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WeatherCondition {
    SUNNY("Солнечно"), CLOUDY("Облачно"), RAINY("Дождливо"), WINDY("Ветрено"), FOGGY("Туманно"), SNOWY("Снежно");

    private final String condition;
}
