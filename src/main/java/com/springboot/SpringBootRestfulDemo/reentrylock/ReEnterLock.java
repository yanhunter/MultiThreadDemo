package com.springboot.SpringBootRestfulDemo.reentrylock;

/**
 * @author yan
 * @desc ReEnterLock
 * @date 2021/11/15
 */
public class ReEnterLock {
   	public static void main(String[] args) {
   			LockReEnter demo = new LockReEnter();
   			new Thread(demo).start();
   			new Thread(demo).start();
   		}

}
