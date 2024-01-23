package com.lxi.springboot.quizapp.events;

import lombok.Value;

@Value
public class ChallengeSolvedEvent {
    private long attemptId;
    private boolean correct;
    private String userAlias;
}
