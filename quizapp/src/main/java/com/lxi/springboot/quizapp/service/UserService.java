package com.lxi.springboot.quizapp.service;

import org.springframework.stereotype.Service;

import com.lxi.springboot.quizapp.model.User;
import com.lxi.springboot.quizapp.model.UserDTO;
import com.lxi.springboot.quizapp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User signUp(UserDTO userDTO){
         User user = userRepository.findByUserName(userDTO.userName())
         .orElseGet( () ->{
            log.info("Creating new user with alias {}",userDTO.userName());
                 return userRepository.save(new User(null,userDTO.userName()));

         }
         );
         return user;
    }

    // public Page<User> getTopTen(){
    //     long totalUsers = userRepository.count();

    //     int fetch = Math.min(10,(int)totalUsers);

    //     PageRequest pageRequest = PageRequest.of(0, fetch);
    //         return userRepository.findAllByOrderByRanksDesc(pageRequest);
    // }
}
