package com.lxi.springboot.quizapp.model;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class OptionsDTO {
    private Long id;
    private String optionA;

    private String optionB;

    private String optionC;
}
