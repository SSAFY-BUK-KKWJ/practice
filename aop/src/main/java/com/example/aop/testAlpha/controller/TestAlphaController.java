package com.example.aop.testAlpha.controller;

import com.example.aop.testAlpha.service.TestAlphaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestAlphaController {

    @Autowired
    private TestAlphaService testAlphaService;

    @GetMapping("")
    public void getTest() throws Exception {
        testAlphaService.getTest();

        System.out.println("Controller 테스트 코드");
    }



}
