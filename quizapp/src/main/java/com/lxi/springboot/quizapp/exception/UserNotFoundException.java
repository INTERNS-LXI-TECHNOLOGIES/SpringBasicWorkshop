package com.lxi.springboot.quizapp.exception;

public class UserNotFoundException extends RuntimeException{
    
      public UserNotFoundException(String message){
        super(message);
      }
}
