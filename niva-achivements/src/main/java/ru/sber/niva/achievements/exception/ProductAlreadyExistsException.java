package ru.sber.niva.achievements.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExistsException extends AchievementServiceException {
    public ProductAlreadyExistsException(String vendorCode) {
        super(HttpStatus.BAD_REQUEST, String.format("Продукт с vendorCode '%s' уже существует", vendorCode));
    }
}
