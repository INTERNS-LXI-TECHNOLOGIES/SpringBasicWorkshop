package com.lxi.springboot.quizapp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lxi.springboot.quizapp.eventpublisher.ChallengeEventPublisher;
import com.lxi.springboot.quizapp.events.ChallengeSolvedEvent;
import com.lxi.springboot.quizapp.exception.UserNotFoundException;
import com.lxi.springboot.quizapp.model.Answer;
//import com.lxi.springboot.quizapp.model.Answer;
import com.lxi.springboot.quizapp.model.Attempt;
import com.lxi.springboot.quizapp.model.AttemptDTO;
import com.lxi.springboot.quizapp.model.Option;
import com.lxi.springboot.quizapp.model.OptionsDTO;
import com.lxi.springboot.quizapp.model.Question;
import com.lxi.springboot.quizapp.model.QuestionDTO;
import com.lxi.springboot.quizapp.model.User;
//import com.lxi.springboot.quizapp.repository.AnswrRepository;
import com.lxi.springboot.quizapp.repository.AttemptRepository;
import com.lxi.springboot.quizapp.repository.QuestionRepository;
import com.lxi.springboot.quizapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttemptService {
    

    private final QuestionRepository questionRepo;
    private final UserRepository userRepository;
    //private final AnswrRepository answerRepository;
    private final ChallengeEventPublisher challengeEventPublisher;

    private final AttemptRepository attemptRepository;
    
      

     public List<QuestionDTO> getAllQuestions(){
         
        return questionRepo.findAllQuestionsWithOptions().stream()
               .map(this::convertToQuestionDTO)
               .toList();

    }

    private QuestionDTO convertToQuestionDTO(Question question){
        log.info("Is the options null "+(question.getOption() != null));
        return new QuestionDTO(question.getQuestionId(), question.getQuestion(), convertToOptionsDTO(question.getOption()));
    }

    private OptionsDTO convertToOptionsDTO(Option option){
       
        return new OptionsDTO(option.getId(), option.getOptionA(), option.getOptionB(), option.getOptionC());
    }

    public String attempts(AttemptDTO attemptDTO){
        

        if(!userRepository.existsByUserName(attemptDTO.user())){
            throw new UserNotFoundException("User not found");
        }
       //Optional<Question> questionOptional = questionRepo.findByQuestion(attemptDTO.question());
       Answer answr = questionRepo.findAnswerByQuestionText(attemptDTO.question());
        if(answr.getCorrect().equals(attemptDTO.answer())){
            Optional<User> userOptional = userRepository.findByUserName(attemptDTO.user());
            User user = userOptional.get();
            Attempt attempt = new Attempt();
            attempt.setCorrect(true);
            attempt.setUser(user);


            userRepository.save(user);
            
            attemptRepository.save(attempt);


            
            challengeEventPublisher.challengeSolved(new ChallengeSolvedEvent(attemptDTO.attempt(),true, attemptDTO.user()));

            

            return "Answer is correct";
        }else{
            return "Wrong answer";
        }
    }

    
}
