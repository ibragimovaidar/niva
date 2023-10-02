package ru.sber.niva.achievementclient.dto.request;

import lombok.Data;

@Data
public class UpdateUserAchievementRequest {

    private Integer goal;

    private Integer progress;
}
