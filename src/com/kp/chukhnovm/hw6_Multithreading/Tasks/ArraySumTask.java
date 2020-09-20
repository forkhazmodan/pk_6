package com.kp.chukhnovm.hw6_Multithreading.Tasks;

public class ArraySumTask implements Runnable{

    private int sum;
    private int[] intArray;
    private int from;
    private int to;

    public ArraySumTask(int[] intArray, int from, int to) {
        this.intArray = intArray;
        this.from = from;
        this.to = to;
    }

    public void calcSum(){
        for (int i = this.from; i < this.to; i++) {
            this.sum+=intArray[i];
        }
    }

    public int getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        this.calcSum();
    }
}
