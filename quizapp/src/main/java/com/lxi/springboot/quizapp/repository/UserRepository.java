package com.lxi.springboot.quizapp.repository;

import java.util.Optional;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lxi.springboot.quizapp.model.User;

public interface UserRepository extends PagingAndSortingRepository<User,Long>,CrudRepository<User,Long>{
    
    public Optional<User> findByUserName(String userName);

    public boolean existsByUserName(String userName);

}
