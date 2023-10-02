package ru.sber.niva.achievements.model.request;

import lombok.Data;

@Data
public class UpdateUserAchievementRequest {

    private Integer goal;

    private Integer progress;
}
