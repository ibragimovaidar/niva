package ru.sber.niva.achievements.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class NotFoundException extends AchievementServiceException {

    public NotFoundException(UUID id) {
        super(HttpStatus.NOT_FOUND, String.format("Сущность с идентефикатором '%s' не найдена", id));
    }
}
