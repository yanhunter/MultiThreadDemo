package com.springboot.SpringBootRestfulDemo.folder7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yan
 * @desc Account
 * @date 2021/10/31
 */
public class Account implements Runnable{
    private float balance;

    public float getBalance() {
        return balance;
    }

    public void setBalance(final float balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account acc = new Account();
        acc.setBalance(100);

        final ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        15,
                        20,
                        2,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute( acc);
        }
        threadPoolExecutor.shutdown();
    }

    @Override
    public void run() {
        minusMoney(800);
        addMoney(800);
    }

    public void addMoney(float moeny){
        this.setBalance(this.getBalance() + moeny);
    }

    public void minusMoney(float moeny){
        this.setBalance(this.getBalance() - moeny);
    }
}
