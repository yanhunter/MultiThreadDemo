package com.springboot.SpringBootRestfulDemo.juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author yan
 * @desc TestExchanger
 * @date 2021/12/1
 */
public class TestExchanger {
    static Exchanger<String> exchanger= new Exchanger<>();

    static String value;

    public static void main(String[] args) {
        System.out.println(" ========== " );
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    String value1 = exchanger.exchange("T1");
                    System.out.println(Thread.currentThread().getName() +"-"+ value1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String value2 = exchanger.exchange("T2");
                    System.out.println(Thread.currentThread().getName() +"-"+ value2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread2").start();
    }
}
