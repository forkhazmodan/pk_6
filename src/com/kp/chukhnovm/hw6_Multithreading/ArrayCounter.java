package com.kp.chukhnovm.hw6_Multithreading;

import com.kp.chukhnovm.hw6_Multithreading.Tasks.ArraySumTask;

public class ArrayCounter {

    public static int countIntegers(int[] array, int threadsCount) {

        Thread[] threads = new Thread[threadsCount];
        ArraySumTask[] tasks = new ArraySumTask[threadsCount];

        // Find out bounds of chunks
        int[][] chunkBounds = ArrayCounter.getBounds(threadsCount, array);

        for (int i = 0; i < chunkBounds.length; i++) {
            int from = chunkBounds[i][0];
            int to = chunkBounds[i][1];
            tasks[i] = new ArraySumTask(array, from, to);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        // Join threads
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sum Total result
        int sum = 0;
        for (ArraySumTask task : tasks) {
            sum += task.getSum();
        }

        return sum;
    }

    public static int countIntegers(int[] array) {

        // Sum Total result
        int sum = 0;
        for (int integer : array) {
            sum += integer;
        }

        return sum;
    }

    private static int[][] getBounds(int numOfChunks, int[] array) {

        int ln = array.length;

        int left = ln % numOfChunks;
        int chunkSize = left > 0
                ? ((ln - left) / numOfChunks) + 1
                : ln / numOfChunks;

        int[][] result = new int[numOfChunks][];

        int j = 0;
        for (int i = 0; i < ln; i += chunkSize) {
            int from = i;
            int to = Math.min(ln, i + chunkSize);
            int[] bounds = {from, to};
            result[j++] = bounds;
        }

        return result;
    }
}
