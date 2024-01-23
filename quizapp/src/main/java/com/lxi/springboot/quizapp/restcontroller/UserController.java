package com.lxi.springboot.quizapp.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import com.lxi.springboot.quizapp.model.UserDTO;
import com.lxi.springboot.quizapp.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
  
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
   
   @PostMapping("/signup") 
    public String signUp(@RequestBody UserDTO userDTO){
        return userService.signUp(userDTO)+"Saved";
    }


    //  @GetMapping("/topPerformers")
    // public Page<User> getTopPerformers() {
    //     return userService.getTopTen();
    // }
}
