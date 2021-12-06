package com.springboot.SpringBootRestfulDemo.reentrylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan
 * @desc LockReEnter
 * @date 2021/11/15
 */
public class LockReEnter implements Runnable {

    ReentrantLock lock = new ReentrantLock();

		public void get() {
      		  lock.lock();
      	  	  System.out.print(Thread.currentThread().getId()+"\t");
      		  // 在get方法里调用set
      		  set();
      		  lock.unlock();
      	   }

	   public void set() {
      		lock.lock();
      		System.out.print(Thread.currentThread().getId() + "\t");
      		lock.unlock();
      	   }

	   public void run()
	   { get(); }

}
