package ru.sber.niva.achievements.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="user_achievement")
@Entity
public class UserAchievementEntity extends AbstractEntity {

    private String userId;

    private Integer goal;

    private Integer progress;

    @ManyToOne
    private AchievementEntity achievement;
}
