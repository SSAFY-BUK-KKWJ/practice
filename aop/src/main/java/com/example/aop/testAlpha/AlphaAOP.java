package com.example.aop.testAlpha;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AlphaAOP {

    private static final Logger log = LoggerFactory.getLogger(AlphaAOP.class);

    @Before("execution(* com.example.aop.testAlpha.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.aop.testAlpha.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.aop.testAlpha.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("AfterReturning: " + joinPoint.getSignature().getName() + " result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.testAlpha.controller.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("AfterThrowing: " + joinPoint.getSignature().getName() + " exception: " + e.getMessage());
    }


    @Around("execution(* com.example.aop.testAlpha.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around Before: " + joinPoint.getSignature().getName());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable t) {
            System.out.println("AOP result에서 에러 발생");
        }

        log.info("Around After: " + joinPoint.getSignature().getName());

        return result;
    }

}
