package ru.sber.niva.metricadapterapi.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MetricRecord {

    private String code;

    private String userId;

    private Integer value;

    private Integer quarter;

    private Integer year;

    private LocalDateTime recordDate;
}
