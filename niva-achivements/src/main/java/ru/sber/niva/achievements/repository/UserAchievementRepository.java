package ru.sber.niva.achievements.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sber.niva.achievements.model.domain.UserAchievementEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserAchievementRepository extends JpaRepository<UserAchievementEntity, UUID>,
        JpaSpecificationExecutor<UserAchievementEntity> {

    Page<UserAchievementEntity> findAllByUserId(String userId, Pageable pageable);

    @Query(value = "SELECT e FROM UserAchievementEntity e WHERE e.userId = :userId AND e.createDate > :greater AND e.createDate < :less")
    List<UserAchievementEntity> filter(String userId, LocalDateTime greater, LocalDateTime less);

}
