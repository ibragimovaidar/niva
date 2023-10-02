package ru.sber.niva.achievements.model.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserAchievementRequest {

    private String userId;

    private Integer goal;

    private Integer progress;

    private UUID achievementId;
}
