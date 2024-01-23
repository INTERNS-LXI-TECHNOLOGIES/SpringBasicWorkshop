package com.lxi.springboot.quizapp.eventpublisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lxi.springboot.quizapp.events.ChallengeSolvedEvent;


@Component
public class ChallengeEventPublisher {
   
    private final AmqpTemplate amqpTemplate;

    private final String challengesTopicExchange;

    public ChallengeEventPublisher(final AmqpTemplate amqpTemplate,
    @Value("${amqp.exchange.attempts}")final String challengesTopicExchange){
        this.amqpTemplate = amqpTemplate;
        this.challengesTopicExchange = challengesTopicExchange;
    }


    public void challengeSolved(ChallengeSolvedEvent attempt){
        String routingKey = "attempt." + (attempt.isCorrect() ?
          "correct" : "wrong");

          amqpTemplate.convertAndSend(challengesTopicExchange,routingKey,attempt);
    }
}
