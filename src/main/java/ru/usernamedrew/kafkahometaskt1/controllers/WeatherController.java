package ru.usernamedrew.kafkahometaskt1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.usernamedrew.kafkahometaskt1.kafka.WeatherProducer;

@RestController
@AllArgsConstructor
public class WeatherController {

    private final WeatherProducer weatherProducer;

    @PostMapping("weather/send")
    public String send(@RequestBody String message) {

        weatherProducer.send(message);

        return "Success";
    }
}
