package ru.sber.niva.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.niva.achievementclient.AchievementFeignClient;
import ru.sber.niva.achievementclient.dto.request.FilterRequest;
import ru.sber.niva.achievementclient.dto.response.AchievementResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementFeignClient achievementClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement/user/{userId}")
    public Page<AchievementResponse> getUserAchievements(@PathVariable String userId, Pageable pageable, @RequestHeader HttpHeaders headers) {
        return achievementClient.getUserAchievements(userId, pageable, headers);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement/{id}")
    public AchievementResponse getAchievement(@PathVariable UUID id, @RequestHeader HttpHeaders headers) {
        headers.clearContentHeaders();
        return achievementClient.getAchievement(id, headers);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement")
    public Page<AchievementResponse> getAchievements(@SpringQueryMap Pageable pageable, @RequestHeader HttpHeaders headers) {
        headers.clearContentHeaders();
        return achievementClient.getAchievements(pageable, headers);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement/filter")
    public List<AchievementResponse> filter(@RequestBody FilterRequest request, @RequestHeader HttpHeaders headers) {
        headers.clearContentHeaders();
        return achievementClient.filter(request, headers);
    }
}
