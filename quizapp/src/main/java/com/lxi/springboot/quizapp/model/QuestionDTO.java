package com.lxi.springboot.quizapp.model;

import lombok.Value;

@Value
public class QuestionDTO {
  
    private Long id;
    private String questionText;
    private OptionsDTO option;
}
