package com.springboot.SpringBootRestfulDemo.juc.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yan
 * @desc TestReadWriteLock
 * @date 2021/12/1
 */
public class TestReadWriteLock {

    static ReentrantLock lock = new ReentrantLock();

    static   ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();


    static int value;

    public static void main(String[] args) {
        Runnable r = ()->{
            //read(lock);
            read(readLock);
        };

        Runnable w = ()->{
            //write(lock, new Random().nextInt());
            write(writeLock, new Random().nextInt());
        };

        for (int i = 0; i <2 ; i++) {
            new Thread(w).start();
        }
        for (int i = 0; i <100 ; i++) {
            new Thread(r).start();
        }
    }

    public static void read(Lock lock){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read done: "+ value);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            value = v;
            System.out.println("write done."+ v);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
