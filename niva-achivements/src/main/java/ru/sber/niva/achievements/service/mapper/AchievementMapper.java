package ru.sber.niva.achievements.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.sber.niva.achievements.model.domain.AchievementEntity;
import ru.sber.niva.achievements.model.request.AchievementRequest;
import ru.sber.niva.achievements.model.response.AchievementResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AchievementMapper {

    AchievementResponse toResponse(AchievementEntity entity);

    AchievementEntity toEntity(AchievementRequest request);

}
