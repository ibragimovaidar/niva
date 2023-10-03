package ru.sber.niva.metricadapterapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "kafka.out")
public class MetricAdapterProducerProperties {

    private String bootstrapServers;

    private String metricProducerTopic;
}
