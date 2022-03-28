package com.lxisoft.repository;

import com.lxisoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select user from User user where user.username = :username")
    public User findUserByName(String username);
}
