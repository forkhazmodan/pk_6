package com.kp.chukhnovm.hw6_Multithreading.Tasks;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactorialTask implements Runnable {

    int number;
    private BigInteger factSum = new BigInteger("0");

    public BigInteger getFactSum() {
        return factSum;
    }

    public FactorialTask() {}

    public FactorialTask(int number) {
        this.number = number;
    }

    public BigInteger calculateFactorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(name);

        if(m.find()) {
            int n = Integer.parseInt(m.group(0));
            BigInteger f = calculateFactorial(n);
            System.out.println(Thread.currentThread().getName() + " => " + n + "!=" + f);
        }
    }
}
