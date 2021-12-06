package com.springboot.SpringBootRestfulDemo.yield;

/**
 * @author yan
 * @desc YieldThread
 * @date 2021/11/29
 */
public class YieldThread implements Runnable{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            if (i == 3) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldThread yThield = new YieldThread();
        new Thread(yThield,"A").start();
        new Thread(yThield,"B").start();
    }
}
