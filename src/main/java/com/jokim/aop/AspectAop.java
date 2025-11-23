package com.jokim.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAop {

    @Around("execution(* com.jokim.aop.AopService.*(..))")
    public void aroundMethodByExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aroundMethod before: " + joinPoint.getSignature().getName());
        joinPoint.proceed();
        System.out.println("aroundMethod after: " + joinPoint.getSignature().getName());
    }

    @Before("@annotation(BeforeMethodByAnnotation)")
    public void beforeMethodByAnnotation(JoinPoint joinPoint) {
        System.out.println("beforeMethod by annotation: " + joinPoint.getSignature().getName());
    }

    @After("bean(simpleAopService)")
    public void afterMethodByBean(JoinPoint joinPoint) {
        System.out.println("afterMethod by bean: " + joinPoint.getSignature().getName());
    }
}
