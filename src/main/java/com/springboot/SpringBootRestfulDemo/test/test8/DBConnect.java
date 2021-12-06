package com.springboot.SpringBootRestfulDemo.test.test8;

import java.util.concurrent.Semaphore;

/**
 * @author yan
 * @desc DBConnect
 * @date 2021/11/27
 */
public class DBConnect extends Thread{

    private Semaphore semaphore;

    public DBConnect(final Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(semaphore.availablePermits()>0){
            System.out.println(Thread.currentThread().getName() + " start，apply the connection, and semaphore.availablePermits() is: "+ semaphore.availablePermits());
        } else {
            System.out.println(Thread.currentThread().getName() + " start，no available connectionm, bc semaphore.availablePermits() is: "+ semaphore.availablePermits());
        }

        try {
            semaphore.acquire();
            System.out.println(" Get DB Connection. " );
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(50, true);
        for (int i = 0; i < 100; i++) {
            final DBConnect dbConnect = new DBConnect(semaphore);
            dbConnect.start();
        }
    }
}
