package ru.usernamedrew.kafkahometaskt1.kafka;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WeatherConsumer {
    // Знаю, не лучшее решение хранить так аналитику. Неуспеваю сделать норм :(
    private final Map<String, Double> maxTemperature = new HashMap<>();
    private final Map<String, Double> minTemperature = new HashMap<>();

    @KafkaListener(topics = "weather")
    public void listen(ConsumerRecord<Long, WeatherDTO> record) {
        WeatherDTO weatherDTO = record.value();
        log.info("Received weather message: " + weatherDTO.toString());

        updateWeatherAnalytics(weatherDTO);
    }

    private void updateWeatherAnalytics(WeatherDTO weatherDTO) {
        maxTemperature.merge(weatherDTO.getCity(), weatherDTO.getTemperature(), Math::max);
        minTemperature.merge(weatherDTO.getCity(), weatherDTO.getTemperature(), Math::min);
    }

    public Map<String, Double> getMaxTemperature() {
        return Collections.unmodifiableMap(maxTemperature);
    }

    public Map<String, Double> getMinTemperature() {
        return Collections.unmodifiableMap(minTemperature);
    }
}
