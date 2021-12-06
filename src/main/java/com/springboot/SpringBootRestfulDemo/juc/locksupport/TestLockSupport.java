package com.springboot.SpringBootRestfulDemo.juc.locksupport;

import com.springboot.SpringBootRestfulDemo.juc.latch.TestCountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yan
 * @desc TestLockSupport
 * @date 2021/12/2
 */
public class TestLockSupport {

    volatile List<String> list = new ArrayList<>();

    public void add(String value){
        list.add(value);
    }
    public int size(){
        return list.size();
    }

    static Thread thread1 , thread2;

    public static void main(String[] args) {
        final TestCountDownLatch testCountDownLatch = new TestCountDownLatch();

        thread2 = new Thread(()->{
            System.out.println("T2 start.");
            try {
                LockSupport.park();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("T2 end.");
            LockSupport.unpark(thread1);
        }, "Thread2");
        thread2.start();


        thread1 = new Thread(() -> {
            System.out.println("T1 start.");
            for (int i = 0; i < 10; i++) {
                testCountDownLatch.add("value" + i);
                System.out.println("add " + i);
                if (testCountDownLatch.size() == 5) {
                    try {
                        LockSupport.unpark(thread2);
                        LockSupport.park();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("T1 end.");
        }, "Thread1");
        thread1.start();


    }
}
