package com.bjit.aspect;

import com.bjit.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Dictionary;

@Component
@Aspect
@Slf4j
public class AOPService {

//    @Before("execution(* com.bjit.controller.CustomerController.*(..))")
//    public void before(){
//      log.info("execute before finalAll()");
//    }

    @After("execution(* com.bjit.controller.CustomerController.findAll())")
    public void after(){
        log.info("execute after finalAll()");
    }

    // PointCut
    @AfterReturning(pointcut = "execution(* com.bjit.controller.CustomerController.findAll())")
    public void afterRunning(){
        log.info("execute after Running finalAll()");
    }

    // jointCut
//    @Around("execution(* com.bjit.controller.CustomerController.getfOne(..))")
//    public Customer around(ProceedingJoinPoint joinPoint){
//
//        return new Customer(2L, "lIton", new ArrayList<>());
//    }

}
