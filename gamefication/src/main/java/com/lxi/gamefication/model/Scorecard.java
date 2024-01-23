package com.lxi.gamefication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scorecard {

    private static final int DEFAULT_SCORE = 10;

    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private long rankList;

   {
     this.rankList = DEFAULT_SCORE;
   }

}
