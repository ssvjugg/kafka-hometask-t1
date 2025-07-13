package ru.usernamedrew.kafkahometaskt1.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;

@Service
@Slf4j
public class WeatherConsumer {

    @KafkaListener(topics = "weather")
    public void listen(ConsumerRecord<Long, WeatherDTO> record) {
        log.info("Received weather message: " + record.value());
        System.out.println(record.value());

    }
}
