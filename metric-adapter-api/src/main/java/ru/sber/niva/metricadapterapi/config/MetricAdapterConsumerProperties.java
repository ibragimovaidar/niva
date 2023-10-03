package ru.sber.niva.metricadapterapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@ConfigurationProperties(prefix = "kafka.in")
@Configuration
public class MetricAdapterConsumerProperties {

    private String bootstrapServers;

    private String metricConsumerTopic;
}
