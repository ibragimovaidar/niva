package ru.sber.niva.jirametricadapter;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.sber.niva.metricadapterapi.config.MetricAdapterProducerProperties;
import ru.sber.niva.metricadapterapi.model.MetricRecord;
import ru.sber.niva.metricadapterapi.model.MetricRequest;

@Component
@RequiredArgsConstructor
public class JiraMetricConsumer {

    private final KafkaTemplate<String, MetricRecord> metricAdapterKafkaTemplate;

    private final MetricAdapterProducerProperties metricAdapterProducerProperties;

    private final MetricRetrieverMock metricRetriever;

    @KafkaListener(
            id = "${spring.application.name}",
            topics = "${kafka.in.metric-consumer-topic}",
            containerFactory = "metricAdapterListenerContainerFactory")
    public void handleMetricRequest(MetricRequest metricRequest) {
        metricAdapterKafkaTemplate.send(metricAdapterProducerProperties.getMetricProducerTopic(), metricRetriever.retrieveMetricRecord(metricRequest));
    }
}
