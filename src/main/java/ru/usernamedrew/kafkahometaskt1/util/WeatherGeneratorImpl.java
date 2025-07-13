package ru.usernamedrew.kafkahometaskt1.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.usernamedrew.kafkahometaskt1.api.WeatherGenerator;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherCondition;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@NoArgsConstructor
public class WeatherGeneratorImpl implements WeatherGenerator {
    private static final Random random = new Random();
    private static final List<String> CITIES = Arrays.asList(
            "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
            "Магадан", "Анадырь", "Тюмень", "Сочи", "Владивосток"
    );

    @Override
    public WeatherDTO generateWeather() {
        String city = CITIES.get(random.nextInt(CITIES.size()));
        double temperature = Math.round((random.nextDouble() * 35) * 10) / 10.0; // от 0 до 35 с одним знаком после запятой
        LocalDate date = LocalDate.now().minusDays(random.nextInt(7)); // данные за последние 7 дней
        WeatherCondition condition = WeatherCondition.values()[random.nextInt(WeatherCondition.values().length)];

        return new WeatherDTO(city, temperature, date, condition);
    }
}
