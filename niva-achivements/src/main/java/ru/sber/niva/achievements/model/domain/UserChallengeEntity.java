package ru.sber.niva.achievements.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_challenge")
@Entity
public class UserChallengeEntity extends AbstractEntity {

    private String userId;

    @ManyToOne
    private UserChallengeEntity challenge;
}
