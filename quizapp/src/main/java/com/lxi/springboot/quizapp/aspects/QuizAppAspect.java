package com.lxi.springboot.quizapp.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class QuizAppAspect {
    

    @Pointcut("execution(* com.lxi.springboot.quizapp.service.AttemptService.*(..)) ||"+
    "execution(* com.lxi.springboot.quizapp.service.UserService.*(..))")
    public void pointCuts(){

    }
    @Before("pointCuts()")
    public void beforeMethodExecution(JoinPoint joinPoint){
         
        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());

        log.info("Method before execution: {} with arguments: {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCuts()")
    public void afterAdvice(JoinPoint joinPoint){
         
        Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());

        log.info("Method after execution: {} ", joinPoint.getSignature().getName());

    }
}
