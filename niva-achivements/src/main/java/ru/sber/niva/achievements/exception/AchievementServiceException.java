package ru.sber.niva.achievements.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AchievementServiceException extends RuntimeException {

    private final HttpStatus status;

    private final String errorDescription;

    public AchievementServiceException(HttpStatus status, String errorDescription) {
        this.status = status;
        this.errorDescription = errorDescription;
    }

    public AchievementServiceException(String message, HttpStatus status, String errorDescription) {
        super(message);
        this.status = status;
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return String.format("ShopRestServiceException(status=%s,errorDescription=%s,message=%s)",
                status, errorDescription, super.getMessage());
    }
}
