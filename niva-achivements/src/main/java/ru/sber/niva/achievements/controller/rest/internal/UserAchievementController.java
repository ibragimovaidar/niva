package ru.sber.niva.achievements.controller.rest.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sber.niva.achievements.model.request.UpdateUserAchievementRequest;
import ru.sber.niva.achievements.model.response.UserAchievementResponse;
import ru.sber.niva.achievements.service.AchievementService;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/internal/user/achievement")
@RestController
public class UserAchievementController {

    private final AchievementService achievementService;

    @PutMapping("/{id}")
    public UserAchievementResponse update(@PathVariable UUID id, @RequestBody UpdateUserAchievementRequest request) {
        return achievementService.updateUserAchievement(id, request);
    }
}
