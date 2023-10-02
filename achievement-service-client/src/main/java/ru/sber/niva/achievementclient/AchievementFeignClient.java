package ru.sber.niva.achievementclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sber.niva.achievementclient.dto.request.FilterRequest;
import ru.sber.niva.achievementclient.dto.response.AchievementResponse;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "achievement", url ="${external.achievement.url}")
public interface AchievementFeignClient {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement/user/{userId}")
    Page<AchievementResponse> getUserAchievements(@PathVariable String userId, @SpringQueryMap Pageable pageable, @RequestHeader HttpHeaders headers);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement/{id}")
    AchievementResponse getAchievement(@PathVariable UUID id, @RequestHeader HttpHeaders headers);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/achievement")
    Page<AchievementResponse> getAchievements(@SpringQueryMap Pageable pageable, @RequestHeader HttpHeaders headers);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/v1/achievement/filter")
    List<AchievementResponse> filter(@RequestBody FilterRequest request, @RequestHeader HttpHeaders headers);
}
