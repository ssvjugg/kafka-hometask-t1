package ru.usernamedrew.kafkahometaskt1.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("weather", message);
    }
}
