package ru.sber.niva.achievements.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sber.niva.achievements.model.request.FilterRequest;
import ru.sber.niva.achievements.exception.NotFoundException;
import ru.sber.niva.achievements.model.domain.UserAchievementEntity;
import ru.sber.niva.achievements.model.request.AchievementRequest;
import ru.sber.niva.achievements.model.request.CreateUserAchievementRequest;
import ru.sber.niva.achievements.model.request.UpdateUserAchievementRequest;
import ru.sber.niva.achievements.model.response.UserAchievementResponse;
import ru.sber.niva.achievements.model.response.AchievementResponse;
import ru.sber.niva.achievements.repository.AchievementRepository;
import ru.sber.niva.achievements.repository.UserAchievementRepository;
import ru.sber.niva.achievements.service.mapper.AchievementMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AchievementService {

    private final UserAchievementRepository userAchievementRepository;

    private final AchievementRepository achievementRepository;

    private final AchievementMapper achievementMapper;

    public Page<AchievementResponse> getUserAchievements(String userId, Pageable pageable) {
        return userAchievementRepository.findAllByUserId(userId, pageable)
                .map(UserAchievementEntity::getAchievement)
                .map(achievementMapper::toResponse);
    }

    public AchievementResponse getById(UUID id) {
        return achievementRepository
                .findById(id)
                .map(achievementMapper::toResponse)
                .orElseThrow();
    }

    public UserAchievementResponse createUserAchievement(CreateUserAchievementRequest request) {
        var achievement = achievementRepository.findById(request.getAchievementId())
                .orElseThrow(() -> new NotFoundException(request.getAchievementId()));
        var userAchievementEntity = new UserAchievementEntity(
                request.getUserId(),
                request.getGoal(),
                request.getProgress(),
                achievement);
        userAchievementEntity.setUpdateDate(LocalDateTime.now());
        userAchievementEntity.setCreateDate(LocalDateTime.now());
        return mapToUserAchievementResponse(userAchievementRepository.save(userAchievementEntity));
    }

    public AchievementResponse createAchievement(AchievementRequest request) {
        var entity = achievementMapper.toEntity(request);
        entity.setCreateDate(LocalDateTime.now());
        entity.setUpdateDate(LocalDateTime.now());
        return achievementMapper.toResponse(
                achievementRepository.save(entity));
    }


    public Page<AchievementResponse> getAchievements(Pageable pageable) {
        return achievementRepository.findAll(pageable)
                .map(achievementMapper::toResponse);
    }

    public List<AchievementResponse> filter(FilterRequest request) {
        return userAchievementRepository.filter(
                        request.getUserId(),
                        request.getGreater(),
                        request.getLess())
                .stream()
                .map(UserAchievementEntity::getAchievement)
                .map(achievementMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserAchievementResponse updateUserAchievement(UUID id, UpdateUserAchievementRequest request) {
        var userAchievement = userAchievementRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        userAchievement.setGoal(request.getGoal());
        userAchievement.setProgress(request.getProgress());
        userAchievement.setUpdateDate(LocalDateTime.now());
        return mapToUserAchievementResponse(userAchievementRepository.save(userAchievement));
    }

    UserAchievementResponse mapToUserAchievementResponse(UserAchievementEntity entity) {
        var response = new UserAchievementResponse();
        response.setId(entity.getId());
        response.setAchievement(achievementMapper.toResponse(entity.getAchievement()));
        response.setGoal(entity.getGoal());
        response.setProgress(entity.getProgress());
        response.setUpdateDate(entity.getUpdateDate());
        response.setCreateDate(entity.getCreateDate());
        return response;
    }
}
