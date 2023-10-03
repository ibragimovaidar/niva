package ru.sber.niva.metricadapterapi.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.sber.niva.metricadapterapi.model.MetricRecord;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class MetricAdapterProducerConfiguration {

    private final MetricAdapterProducerProperties producerProperties;

    @Bean
    public KafkaTemplate<String, MetricRecord> metricAdapterKafkaTemplate() {
        return new KafkaTemplate<>(metricAdapterProducerFactory());
    }

    @Bean
    public ProducerFactory<String, MetricRecord> metricAdapterProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerProperties.getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }
}
