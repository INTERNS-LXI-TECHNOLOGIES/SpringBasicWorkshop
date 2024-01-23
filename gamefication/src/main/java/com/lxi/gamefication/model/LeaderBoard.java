package com.lxi.gamefication.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderBoard {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userAlias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score_id")
    private Scorecard scorecard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "badge_id")
    private BadgeCard badgeCard;
}
