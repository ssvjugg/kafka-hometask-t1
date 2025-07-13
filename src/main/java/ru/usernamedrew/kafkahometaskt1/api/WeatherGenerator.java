package ru.usernamedrew.kafkahometaskt1.api;

import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;

public interface WeatherGenerator {
    /**
     * Функция для генерации синтетических данных о погоде
     * @return WeatherDTO класс для передачи данныз о погоде
     */
    WeatherDTO generateWeather();
}
