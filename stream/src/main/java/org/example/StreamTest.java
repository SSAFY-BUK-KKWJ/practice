package org.example;

import java.util.Arrays;

public class StreamTest {

    public static void main(String[] args) {
        int[] ints = new int[10_000_000];
        for (int i = 0; i < ints.length; i++) ints[i] = (int) Math.random();
        int[] a = ints;
        int e = a.length;

        long beforeTime = System.currentTimeMillis();
//        int m = Integer.MIN_VALUE;  // for 문
//        for (int i = 0; i < e; i++) {
//            if (a[i] > m) m = a[i];
//        }

        int m = Arrays.stream(ints).reduce(Integer.MIN_VALUE, Math::max); // stream
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간 차이 : " + secDiffTime);
    }

}
