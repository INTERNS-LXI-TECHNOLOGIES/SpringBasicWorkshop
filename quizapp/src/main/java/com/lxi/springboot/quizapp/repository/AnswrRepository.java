package com.lxi.springboot.quizapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxi.springboot.quizapp.model.Answer;

@Repository
public interface AnswrRepository extends CrudRepository<Answer,Long>{
    
    // @Query("SELECT a FROM Answer a LEFT JOIN a.question q WHERE q.question = :questionText")
    // Answer findAnswerUsingQuestion(@Param("questionText") String questionText);
}
