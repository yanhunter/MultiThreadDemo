package com.springboot.SpringBootRestfulDemo.lock;

/**
 * @author yan
 * @desc LockDemo
 * @date 2021/11/15
 */
public class LockDemo {
    	public static void main(String[] args) {
            AccountWithLock acc = new AccountWithLock();
            Thread add = new AddThreadWithLock("Tom", acc);
            Thread minus = new MinusThreadWithLock("Peter", acc);
            add.start();
            minus.start();
        }

}
