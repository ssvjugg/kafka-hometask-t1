package ru.usernamedrew.kafkahometaskt1.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.usernamedrew.kafkahometaskt1.api.WeatherGenerator;
import ru.usernamedrew.kafkahometaskt1.dto.WeatherDTO;

@Service
@AllArgsConstructor
public class WeatherProducer {

    private final KafkaTemplate<Long, WeatherDTO> kafkaTemplate;

    private final WeatherGenerator weatherGenerator;

    @Scheduled(fixedRate = 5000)
    public void send() {
        WeatherDTO weatherDTO = weatherGenerator.generateWeather();
        kafkaTemplate.send("weather", weatherDTO);
    }

    public void send(WeatherDTO weatherDTO) {
        kafkaTemplate.send("weather", weatherDTO);
    }
}
