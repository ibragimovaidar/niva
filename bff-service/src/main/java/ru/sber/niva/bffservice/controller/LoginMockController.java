package ru.sber.niva.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.sber.niva.bffservice.config.ApplicationProperties;
import ru.sber.niva.bffservice.model.auth.LoginMockRequest;
import ru.sber.niva.bffservice.model.auth.UserFields;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginMockController {

    public final ApplicationProperties applicationProperties;

    @PostMapping
    public ResponseEntity<UserFields> login(@RequestBody LoginMockRequest loginMockRequest) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        var session = requestAttributes.getRequest().getSession(true);
        var userFields = new UserFields(
                loginMockRequest.getUserId(),
                loginMockRequest.getRole(),
                loginMockRequest.getTribeId(),
                loginMockRequest.getAreaId(),
                loginMockRequest.getFirstName(),
                loginMockRequest.getLastName(),
                loginMockRequest.getPatronymic());
        session.setAttribute("user", userFields);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.LOCATION, applicationProperties.getLoginRedirectUrl())
                .body(userFields);
    }
}
