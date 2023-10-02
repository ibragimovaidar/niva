package ru.sber.niva.achievementclient.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserAchievementRequest {

    private String userId;

    private Integer goal;

    private Integer progress;

    private UUID achievementId;
}
