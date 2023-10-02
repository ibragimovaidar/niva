package ru.sber.niva.achievementclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sber.niva.achievementclient.dto.request.AchievementRequest;
import ru.sber.niva.achievementclient.dto.request.CreateUserAchievementRequest;
import ru.sber.niva.achievementclient.dto.request.UpdateUserAchievementRequest;
import ru.sber.niva.achievementclient.dto.response.AchievementResponse;
import ru.sber.niva.achievementclient.dto.response.UserAchievementResponse;

import java.util.UUID;

@FeignClient(name = "achievement-internal", url = "${external.achievement.url}")
public interface AdvertisementInternalClient {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/achievement/user")
    UserAchievementResponse createUserAchievement(@RequestBody CreateUserAchievementRequest request, @RequestHeader HttpHeaders headers);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/achievement")
    AchievementResponse createAchievement(@RequestBody AchievementRequest achievementRequest, @RequestHeader HttpHeaders headers);

    @PutMapping("/user/achievement/{id}")
    UserAchievementResponse update(@PathVariable UUID id, @RequestBody UpdateUserAchievementRequest request, @RequestHeader HttpHeaders headers);
}
