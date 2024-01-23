package com.lxi.springboot.quizapp.configuration;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AMQPConfiguration {
    
    // this method loads a bean of TopicExchange for message broker TopicExchange is an AMQP exchange type used for routing messages based on wildcard matches.
    @Bean
    public TopicExchange challengesTopicExchange(@Value("${amqp.exchange.attempts}") final String exchangeName){
          
        return ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
    }

    //Jackson2JsonMessageConverter bean. This converter is used for converting messages to and from JSON format. It's commonly used in Spring AMQP for message serialization/deserialization when dealing with JSON payloads.
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
}

}
