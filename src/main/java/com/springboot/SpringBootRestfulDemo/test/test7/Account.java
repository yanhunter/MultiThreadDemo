package com.springboot.SpringBootRestfulDemo.test.test7;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan
 * @desc TaobaoOrder
 * @date 2021/11/26
 */
public class Account implements Runnable{
    private float balance;
    private Lock lock;

    public float getBalance() {
        return balance;
    }

    public void setBalance(final float balance) {
        this.balance = balance;
    }

    public Account(final float balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Account account = new Account(1000f);

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(15, 20, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 10; i++) {
            final Future<?> submit = threadPoolExecutor.submit(account);
            submit.get();
        }
        threadPoolExecutor.shutdown();
        System.out.println("account.balance = " + account.balance);
    }

    @Override
    public void run() {
        try {
            lock.lock();
            if(getBalance()<800){
                System.out.println(" warning " );
            }
            minusMoney(800);
            addMoney(800);
        }finally {
            lock.unlock();
        }

    }

    public void addMoney(float moeny){
        this.setBalance(this.getBalance() + moeny);
    }

    public void minusMoney(float moeny){
        this.setBalance(this.getBalance() - moeny);
    }
}


