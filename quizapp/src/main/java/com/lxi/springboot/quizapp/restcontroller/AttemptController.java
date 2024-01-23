package com.lxi.springboot.quizapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxi.springboot.quizapp.model.AttemptDTO;
import com.lxi.springboot.quizapp.model.QuestionDTO;
import com.lxi.springboot.quizapp.service.AttemptService;

@RestController
public class AttemptController {
   
   private final AttemptService attemptService;
   

   public AttemptController(AttemptService attemptService){
       this.attemptService = attemptService;
   }

   @GetMapping("/questions")
    public List<QuestionDTO> getAllQuestions(){
    return attemptService.getAllQuestions();
    }

    @PostMapping("/postanswer")
    public String attempts(@RequestBody AttemptDTO attemptDTO){
        return attemptService.attempts(attemptDTO);
    }

    
}
