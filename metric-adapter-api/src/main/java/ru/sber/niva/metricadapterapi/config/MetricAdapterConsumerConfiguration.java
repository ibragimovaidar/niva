package ru.sber.niva.metricadapterapi.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.sber.niva.metricadapterapi.model.MetricRequest;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class MetricAdapterConsumerConfiguration {

    private final MetricAdapterConsumerProperties consumerProperties;

    @Bean
    public ConsumerFactory<String, MetricRequest> metricAdapterConsumerFactory() {
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerProperties.getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerProperties.getMetricConsumerTopic());
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MetricRequest> metricAdapterListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MetricRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(metricAdapterConsumerFactory());
        factory.setBatchListener(false);
        return factory;
    }
}
