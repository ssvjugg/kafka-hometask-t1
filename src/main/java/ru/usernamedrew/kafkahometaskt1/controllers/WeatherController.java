package ru.usernamedrew.kafkahometaskt1.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;
import ru.usernamedrew.kafkahometaskt1.kafka.WeatherConsumer;
import ru.usernamedrew.kafkahometaskt1.kafka.WeatherProducer;

@RestController
@RequestMapping("weather")
@AllArgsConstructor
@Slf4j
public class WeatherController {

    private final WeatherProducer weatherProducer;

    private final WeatherConsumer weatherConsumer;

    @PostMapping("send")
    public String send(@RequestBody WeatherDTO weatherDTO) {
        log.info("Sending weather message: " + weatherDTO.toString());

        weatherProducer.send(weatherDTO);

        return "Success";
    }

    @GetMapping("analytics")
    public String getAnalytics() {
        // Логики не много поэтому оставил в контролере
        StringBuilder analytics = new StringBuilder();

        analytics.append("Максимальная температура по городам:\n");
        weatherConsumer.getMaxTemperature()
                .forEach((city, temperature) ->
                        analytics.append(String.format("- %s: %.1f°C\n", city, temperature)));

        analytics.append("Минимальная температура по городам:\n");
        weatherConsumer.getMinTemperature()
                .forEach((city, temperature) ->
                        analytics.append(String.format("- %s: %.1f°C\n", city, temperature)));

        return analytics.toString();
    }
}
