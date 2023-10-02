package ru.sber.niva.bffservice.model.auth;

import lombok.Data;

@Data
public class LoginMockRequest {

    private String userId;

    private String role;

    private String tribeId;

    private String areaId;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String grade;

    private String jobTitle;
}
