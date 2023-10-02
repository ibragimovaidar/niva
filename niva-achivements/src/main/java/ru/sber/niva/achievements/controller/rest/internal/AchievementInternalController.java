package ru.sber.niva.achievements.controller.rest.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.niva.achievements.model.request.AchievementRequest;
import ru.sber.niva.achievements.model.request.CreateUserAchievementRequest;
import ru.sber.niva.achievements.model.response.AchievementResponse;
import ru.sber.niva.achievements.model.response.UserAchievementResponse;
import ru.sber.niva.achievements.service.AchievementService;

@RequiredArgsConstructor
@RequestMapping("/internal/achievement")
@RestController
public class AchievementInternalController {

    private final AchievementService achievementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    UserAchievementResponse createUserAchievement(@RequestBody CreateUserAchievementRequest request) {
        return achievementService.createUserAchievement(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AchievementResponse createAchievement(@RequestBody AchievementRequest achievementRequest) {
        return achievementService.createAchievement(achievementRequest);
    }
}
