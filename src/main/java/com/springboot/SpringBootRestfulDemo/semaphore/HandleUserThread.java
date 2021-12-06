package com.springboot.SpringBootRestfulDemo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author yan
 * @desc HandleUserThread
 * @date 2021/10/31
 */
public class HandleUserThread extends Thread {
   		private Semaphore semaphore;
		private String threadName;
		private ConnectionProvide provider;
		public HandleUserThread(String threadName, Semaphore semaphore,	ConnectionProvide provider) {
      			this.semaphore = semaphore;
      			this.threadName = threadName;
      			this.provider = provider;
      		}
		public void run() {
              //通过availablePermits得到剩余资源
        		if (semaphore.availablePermits() > 0) {
        				System.out.println(threadName + " start，apply the connection, and semaphore.availablePermits() is: "+ semaphore.availablePermits());
        			} else {
        				System.out.println(threadName + " start，no available connectionm, bc semaphore.availablePermits() is: "+ semaphore.availablePermits());
        			}
              //通过acquire方法申请资源
        		try {
        				semaphore.acquire();
        				provider.provide();
						System.out.println(threadName + " get connection.");
						Thread.sleep(2000);
        				//用好数据库连接后释放该资源
        				semaphore.release();
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
        		}

}
