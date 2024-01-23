package com.lxi.springboot.quizapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxi.springboot.quizapp.model.Answer;
import com.lxi.springboot.quizapp.model.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

    
    @Query("SELECT DISTINCT q FROM Question q left join q.option o1_0")
    List<Question> findAllQuestionsWithOptions();

    Optional<Question> findByQuestion(String questionText);

    @Query("SELECT a FROM Question q left join q.answer a WHERE q.question = :questionText")
    Answer findAnswerByQuestionText(@Param("questionText") String questionText);

   
}
