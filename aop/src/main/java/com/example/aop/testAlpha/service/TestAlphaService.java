package com.example.aop.testAlpha.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TestAlphaService {

    public void getTest() throws Exception {
        System.out.println("Service 테스트 코드");
        throw new Exception();
    }

}
