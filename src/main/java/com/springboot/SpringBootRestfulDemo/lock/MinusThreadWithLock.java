package com.springboot.SpringBootRestfulDemo.lock;

/**
 * @author yan
 * @desc MinusThreadWithLock
 * @date 2021/11/15
 */
public class MinusThreadWithLock extends Thread{

		AccountWithLock acc;
	    String person;

        //在构造函数里，初始化操作的人和账户
 		public MinusThreadWithLock(String person, AccountWithLock acc) {
 			this.person = person;
 			this.acc = acc;
 		}

	    public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               acc.lockAccount();//锁账户
               System.out.println(person + "minus money,"+i+"cnt");
                System.out.println(person + " login ");
                acc.minus();
                System.out.println(person + " logout ");
                acc.logout();
                acc.unLockAccount();//解锁账户
            }
 		}

}
