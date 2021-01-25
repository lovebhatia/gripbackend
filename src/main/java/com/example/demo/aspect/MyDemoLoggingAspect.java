package com.example.demo.aspect;

import com.example.demo.model.Course;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("com.example.demo.aspect.AopExpressions.forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdvicePointCutNoGetterSetter(JoinPoint joinPoint) {
        System.out.println("Executing with point cutAOP "+joinPoint.getSignature().getName());
    }
    
    @Before("com.example.demo.aspect.AopExpressions.forServicePackage()")
    public void beforeAddAccountAdvicePointCut(JoinPoint joinPoint) {
        System.out.println("Executing with point cutAOP "+joinPoint.getSignature().getName());
    }

    @Before("execution(public void com.example.demo.Service.TruncateDatabaseService.truncate())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Executing AOP"+joinPoint.getSignature().getName());
        Object [] args=joinPoint.getArgs();
        for(Object tempargs:args) {
            if(tempargs instanceof Course) {
                Course course=(Course)tempargs;
                System.out.println(course.getCourseName());
            }
        }
    }

  //Add a new advice for @after returning
    @AfterReturning(
            pointcut = "execution(* com.example.demo.Service.TruncateDatabaseService.truncate())",
           returning ="result"
    )
    public void afterReturningAdviceAccount(JoinPoint joinPoint, List<Course> result) {
        //print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning on method: "+method);

        //print out results of method call
        System.out.println("Results ==> "+result);
        //convertCourseNamesToUpperCase(result);

    }
    

}
