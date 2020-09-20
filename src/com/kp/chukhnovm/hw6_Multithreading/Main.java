package com.kp.chukhnovm.hw6_Multithreading;

import com.kp.chukhnovm.hw6_Multithreading.Tasks.FactorialTask;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        task1();
//        task2();
    }

    public static void task2() {
        // Create array of ints
        int[] array = new int[2000000000];
        Random random = new Random();
        for (int i=0; i< array.length; i++) {
            array[i] = random.nextInt(100);
        }

        long start;
        long end;

        start = System.currentTimeMillis();
        ArrayCounter.countIntegers(array);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms" + "- Sync method sort");

        start = System.currentTimeMillis();
        ArrayCounter.countIntegers(array, 5);
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms" + "- Async method sort");


        // 1-st run - 1000000 ints, 5 threads
        // 4 ms- Sync method sort
        // 14 ms- Async method sort

        // 2-nd run - 1000000000 ints, 5 threads
        // 286 ms- Sync method sort
        // 246 ms- Async method sort

        // 3-nd run - 1000000000 ints, 10 threads
        // 288 ms- Sync method sort
        // 248 ms- Async method sort

        // 4-nd run - 1000000000 ints, 5 threads
        // 302 ms- Sync method sort
        // 248 ms- Async method sort

        // 5-nd run - 2000000000 ints, 5 threads
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        // at com.kp.chukhnovm.hw6_Multithreading.Main.task2(Main.java:17)
        // at com.kp.chukhnovm.hw6_Multithreading.Main.main(Main.java:12)
    }

    public static void task1() {
        for (int i = 0; i < 100; i++) {
            new Thread(new FactorialTask()).start();
        }
    }

    public static void asyncTask2() {


    }

}
