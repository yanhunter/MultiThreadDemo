package com.springboot.SpringBootRestfulDemo.readwritelock;

/**
 * @author yan
 * @desc ReadWriteLockDemo
 * @date 2021/11/15
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteTool tool = new ReadWriteTool();

        for (int i = 0; i < 3; i++) {
            new ReadThread(tool).start();
            new WriteThread(tool).start();
        }
    }

}
