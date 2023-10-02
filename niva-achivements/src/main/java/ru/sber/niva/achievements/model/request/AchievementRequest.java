package ru.sber.niva.achievements.model.request;

import lombok.Data;

@Data
public class AchievementRequest {

    private String name;

    private String description;

    private byte[] icon;

    private Integer goal;

    private Integer progress;
}
