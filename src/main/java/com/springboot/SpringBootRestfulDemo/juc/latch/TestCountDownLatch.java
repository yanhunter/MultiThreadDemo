package com.springboot.SpringBootRestfulDemo.juc.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yan
 * @desc TestCountDownLatch
 * @date 2021/12/2
 */
public class TestCountDownLatch {

    volatile List<String> list = new ArrayList<>();

    public void add(String value){
        list.add(value);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final TestCountDownLatch testCountDownLatch = new TestCountDownLatch();

        final CountDownLatch countDownLatch1 = new CountDownLatch(1);
        final CountDownLatch countDownLatch2 = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("T1 start.");
            for (int i = 0; i <10 ; i++) {
                if(testCountDownLatch.size()==5){
                    try {
                        countDownLatch2.countDown();
                        countDownLatch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                testCountDownLatch.add("v"+ i);
                System.out.println("add "+ i);
            }
            System.out.println("T1 end.");
        }, "Thread1").start();

        new Thread(()->{
            System.out.println("T2 start.");
            if(testCountDownLatch.size()!=5){
                try {
                    countDownLatch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T2 end.");
            countDownLatch1.countDown();
        }, "Thread2").start();
    }
}
