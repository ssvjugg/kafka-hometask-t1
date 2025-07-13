package ru.usernamedrew.kafkahometaskt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaHometaskT1Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaHometaskT1Application.class, args);
    }

}
