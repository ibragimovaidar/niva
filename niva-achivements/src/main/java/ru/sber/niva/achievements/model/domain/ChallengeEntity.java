package ru.sber.niva.achievements.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "challenge")
@Entity
public class ChallengeEntity extends AbstractEntity {

    private String name;

    private String description;

    private ChallengeStatus status;

}
