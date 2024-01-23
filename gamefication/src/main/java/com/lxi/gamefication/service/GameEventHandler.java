package com.lxi.gamefication.service;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.lxi.gamefication.model.ChallengeSolvedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class GameEventHandler {

    private final LeaderBoardService leaderBoardService;

    @RabbitListener(queues = "${amqp.queue.gamification}")
    public void quizEventSolver(final ChallengeSolvedEvent challengeSolvedEvent){

        log.info("Challenge Solved Event received: {}", challengeSolvedEvent.getAttemptId());

        try{
            leaderBoardService.saveScore(challengeSolvedEvent);
        }catch(Exception e){
            log.error("Error when trying to process ChallengeSolvedEvent", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
