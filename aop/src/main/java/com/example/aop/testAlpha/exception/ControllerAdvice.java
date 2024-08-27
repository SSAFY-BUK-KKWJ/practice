package com.example.aop.testAlpha.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public void alphaHandler(Exception e) {
        System.out.println("에러 핸들러");
    }


}
