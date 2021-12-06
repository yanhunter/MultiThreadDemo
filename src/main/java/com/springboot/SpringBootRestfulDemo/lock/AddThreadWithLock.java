package com.springboot.SpringBootRestfulDemo.lock;

/**
 * @author yan
 * @desc AddThreadWithLock
 * @date 2021/11/15
 */
public class AddThreadWithLock extends Thread{

    	String person; //操作的人
		AccountWithLock acc;//待操作的账户
	    //在构造函数里，初始化操作的人和账户
    		public AddThreadWithLock(String person, AccountWithLock acc) {
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
                     //在操作前，先锁账户
				acc.lockAccount();
				System.out.println(person +"add money,"+i +" cnt");
				acc.login();
				System.out.println(person + " login ");
				acc.add();
				System.out.println(person + " logout ");
				acc.logout();
				 //操作结束登出后，解锁账户
				acc.unLockAccount();
        		}
    		}

}
