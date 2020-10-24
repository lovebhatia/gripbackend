package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(public List<String> getAllCourses())")
    public void beforeAddAccountAdvice() {
        System.out.println("Exceuting");
    }
}
