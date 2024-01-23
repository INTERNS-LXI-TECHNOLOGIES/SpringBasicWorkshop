package com.lxi.springboot.quizapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lxi.springboot.quizapp.model.Attempt;

public interface AttemptRepository extends PagingAndSortingRepository<Attempt,Long>,CrudRepository<Attempt,Long>{
  
}
