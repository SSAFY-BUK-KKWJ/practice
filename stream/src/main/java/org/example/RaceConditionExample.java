package org.example;

import java.util.stream.IntStream;

public class RaceConditionExample {

    private int counter = 0;

    public static void main(String[] args) {
        RaceConditionExample example = new RaceConditionExample();
        example.runExample();
    }

    public void runExample() {
        // 1000번의 증감 작업을 그냥 수행
        IntStream.range(0, 1000).forEach(i -> incrementCounter());
////         1000번의 증감 작업을 병렬로 수행
//        IntStream.range(0, 1000).parallel().forEach(i -> incrementCounter());

        // 결과 출력
        System.out.println("Final counter value: " + counter);
    }

    private void incrementCounter() {
        // counter 값을 증가시키는 작업
        counter++;
    }

}
