package com.springboot.SpringBootRestfulDemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan
 * @desc AccountWithLock
 * @date 2021/11/15
 */
public class AccountWithLock {
		private	int balance; //余额
		private Lock lock; //锁

		public AccountWithLock() {
      			balance = 0;
      			lock = new ReentrantLock(); //构造时初始化锁对象
      		}

	    //锁账户的方法
      		public void lockAccount()
	         { lock.lock(); 	}
	    //解锁账户的方法
      		public void unLockAccount()
	            { lock.unlock();	}
	        //不需加synchronized
      		public void login() {
      	       //省略验证的代码
      		}
	        //不需加synchronized
      		public void logout() {
      	       //省略退卡登出的代码
      		}
	        //加钱
      		public void add() {
      			balance += 800;
      			System.out.println("After add balance is:" + balance);
      		}
	         //取钱
            public synchronized void minus() {
              balance -= 800;
              System.out.println("After minus balance is:" + balance);
            }

}
