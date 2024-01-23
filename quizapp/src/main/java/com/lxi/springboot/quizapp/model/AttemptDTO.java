package com.lxi.springboot.quizapp.model;

public record AttemptDTO(String user,String question,String answer,Long attempt) {
    
}
