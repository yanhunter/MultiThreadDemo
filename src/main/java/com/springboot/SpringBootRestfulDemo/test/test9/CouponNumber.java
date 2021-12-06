package com.springboot.SpringBootRestfulDemo.test.test9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan
 * @desc CouponNumber
 * @date 2021/11/27
 */
public class CouponNumber implements Runnable{

    private int number;

    private Lock lock;

    public CouponNumber() {
    }

    public CouponNumber(final int number) {
        this.number = number;
        lock = new ReentrantLock();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public void minus(){
        number--;
    }



    public static void main(String[] args) throws InterruptedException {
        final CouponNumber couponNumber = new CouponNumber(100);

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(200, 500, 5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300));

        for (int i = 0; i <300 ; i++) {
            threadPoolExecutor.execute(couponNumber);
        }
        threadPoolExecutor.shutdown();
        Thread.sleep(1000);
        System.out.println("======== couponNumber = " + couponNumber.getNumber());
    }

    @Override
    public void run() {
        /*if(getNumber()<= 0 ){
            System.out.println(" warning , number is " + getNumber());
        }else {
            try {
                //lock.lock();
                minus();
            }finally {
                //lock.unlock();
            }
        }*/

        try {
            lock.lock();
            minus();
        }finally {
            lock.unlock();
        }
    }
}
