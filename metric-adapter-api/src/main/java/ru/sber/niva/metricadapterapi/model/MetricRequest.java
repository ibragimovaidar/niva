package ru.sber.niva.metricadapterapi.model;

import lombok.Data;

import java.util.UUID;

@Data
public class MetricRequest {

    private String code;

    private String userId;
}
