package ru.usernamedrew.kafkahometaskt1.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;
import ru.usernamedrew.kafkahometaskt1.kafka.WeatherProducer;

@RestController
@RequestMapping("weather")
@AllArgsConstructor
@Slf4j
public class WeatherController {

    private final WeatherProducer weatherProducer;

    @PostMapping("send")
    public String send(@RequestBody WeatherDTO weatherDTO) {
        log.info("Sending weather message: " + weatherDTO.toString());

        weatherProducer.send(weatherDTO);

        return "Success";
    }

    @GetMapping("analytics")
    public String getAnalytics() {
        return "Empty"; // TODO
    }
}
