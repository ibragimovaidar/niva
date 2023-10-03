package ru.sber.niva.jirametricadapter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Metric {

    STORY_POINTS("0001"),
    CLOSED_STORIES("0002"),
    BUGS_CLOSED("0003"),
    TASKS_CLOSED("0004"),
    BUGS_PER_STORY("0005"),
    PULL_REQUESTS_MERGED("0006"),
    UNIT_TESTS_MERGED("0007"),
    COURSES_LEARNED("0008");

    private final String code;

    public static Metric getByCode(String code) {
        for (Metric metric : Metric.values()) {
            if (metric.getCode().equals(code)) {
                return metric;
            }
        }
        throw new IllegalArgumentException("Метрики с данным кодов");
    }
}
