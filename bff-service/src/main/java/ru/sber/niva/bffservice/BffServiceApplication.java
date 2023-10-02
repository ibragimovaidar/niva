package ru.sber.niva.bffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.sber.niva.bffservice.config.ApplicationProperties;

@EnableConfigurationProperties(ApplicationProperties.class)
@SpringBootApplication
public class BffServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(BffServiceApplication.class, args);
    }
}