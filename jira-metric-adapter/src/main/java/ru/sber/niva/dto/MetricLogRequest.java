package ru.sber.niva.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class MetricLogRequest {

    private UUID metricId;

    private Integer value;

    private ZonedDateTime date;
}
