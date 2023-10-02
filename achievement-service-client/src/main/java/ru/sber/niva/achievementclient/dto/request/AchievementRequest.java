package ru.sber.niva.achievementclient.dto.request;

import lombok.Data;

@Data
public class AchievementRequest {

    private String name;

    private String description;

    private byte[] icon;

    private Integer goal;

    private Integer progress;
}
