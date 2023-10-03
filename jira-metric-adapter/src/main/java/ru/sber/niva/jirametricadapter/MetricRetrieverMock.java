package ru.sber.niva.jirametricadapter;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import ru.sber.niva.metricadapterapi.model.MetricRecord;
import ru.sber.niva.metricadapterapi.model.MetricRequest;

import java.time.LocalDateTime;

@Service
public class MetricRetrieverMock {

    public MetricRecord retrieveMetricRecord(MetricRequest metricRequest) {
        var metric = Metric.getByCode(metricRequest.getCode());
        var now = LocalDateTime.now();
        var quarter = (now.getMonth().ordinal() / 3) + 1;

        var metricRecord = new MetricRecord();
        metricRecord.setQuarter(quarter);
        metricRecord.setYear(now.getYear());
        metricRecord.setRecordDate(now);
        metricRecord.setUserId(metricRecord.getUserId());
        metricRecord.setCode(metric.getCode());
        if (Metric.BUGS_CLOSED.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(40,60));
        } else if (Metric.BUGS_PER_STORY.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(1,3));
        } else if (Metric.STORY_POINTS.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(80, 200));
        } else if (Metric.PULL_REQUESTS_MERGED.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(100,200));
        } else if (Metric.CLOSED_STORIES.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(5,10));
        } else if (Metric.UNIT_TESTS_MERGED.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(100,200));
        } else if (Metric.COURSES_LEARNED.equals(metric)) {
            metricRecord.setValue(RandomUtils.nextInt(2,5));
        } else {
            metricRecord.setValue(0);
        }
        return metricRecord;
    }
}
