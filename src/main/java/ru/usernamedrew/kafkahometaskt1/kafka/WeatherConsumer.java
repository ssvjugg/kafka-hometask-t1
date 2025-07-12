package ru.usernamedrew.kafkahometaskt1.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WeatherConsumer {

    @KafkaListener(topics = "weather", groupId = "weather_consumer")
    public void listen(String message) {
        System.out.println(message);
    }
}
