package ru.sber.niva.metricadapterapi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MetricAdapterConsumerConfiguration.class, MetricAdapterProducerConfiguration.class})
@EnableConfigurationProperties({MetricAdapterConsumerProperties.class, MetricAdapterProducerProperties.class})
public class MetricAdapterAutoConfiguration {
}
