package ru.sber.niva.achievements.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sber.niva.achievements.exception.AchievementServiceException;
import ru.sber.niva.achievements.model.ErrorResponse;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        log.error("Необрабатываемая ошибка", e);
        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse("Необрабатываемая ошибка сервера"));
    }

    @ExceptionHandler(AchievementServiceException.class)
    public ResponseEntity<ErrorResponse> handleShopRestServiceException(AchievementServiceException e) {
        log.info("Неуспешный запрос", e);
        return ResponseEntity
                .status(e.getStatus())
                .body(new ErrorResponse(e.getErrorDescription()));
    }
}
