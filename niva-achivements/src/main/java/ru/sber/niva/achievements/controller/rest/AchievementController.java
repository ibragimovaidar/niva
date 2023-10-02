package ru.sber.niva.achievements.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sber.niva.achievements.model.request.FilterRequest;
import ru.sber.niva.achievements.model.response.AchievementResponse;
import ru.sber.niva.achievements.service.AchievementService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/achievement")
@RestController
public class AchievementController {

    private final AchievementService achievementService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}")
    public Page<AchievementResponse> getUserAchievements(@PathVariable String userId, Pageable pageable) {
        return achievementService.getUserAchievements(userId, pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AchievementResponse getAchievement(@PathVariable UUID id) {
        return achievementService.getById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<AchievementResponse> getAchievements(Pageable pageable) {
        return achievementService.getAchievements(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/filter")
    public List<AchievementResponse> filter(@RequestBody FilterRequest request) {
        return achievementService.filter(request);
    }
}
