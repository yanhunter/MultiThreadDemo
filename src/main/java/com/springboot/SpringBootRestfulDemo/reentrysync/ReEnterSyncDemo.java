package com.springboot.SpringBootRestfulDemo.reentrysync;

/**
 * @author yan
 * @desc ReEnterSyncDemo
 * @date 2021/11/15
 */
public class ReEnterSyncDemo {

    public static void main(String[] args) {
        SyncReEnter demo=new SyncReEnter();
        new Thread(demo).start();
        new Thread(demo).start();
    }

}
