package ru.sber.niva.bffservice.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFields {

    private String userId;

    private String role;

    private String tribeId;

    private String areaId;

    private String firstName;

    private String lastName;

    private String patronymic;
}
