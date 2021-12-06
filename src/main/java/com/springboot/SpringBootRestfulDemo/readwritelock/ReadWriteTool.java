package com.springboot.SpringBootRestfulDemo.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yan
 * @desc ReadWriteTool
 * @date 2021/11/15
 */
public class ReadWriteTool {

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		private Lock readLock = lock.readLock();
		private Lock writeLock = lock.writeLock();
		private int num = 0;

        //读的方法
	  	public void read() {
      	int cnt = 0;

      	while (cnt++ < 3) {
      			try {
      				readLock.lock();
      				System.out.println(Thread.currentThread().getId() + " start to read");

      	            //System.out.println(Thread.currentThread().getId() + " reading,"	+ num);
      	            System.out.println(Thread.currentThread().getId() + " reading,"	);
                    Thread.sleep(1000);
      			} catch (Exception e)
                  { e.printStackTrace();}
                  finally { readLock.unlock(); 	}
      		}

      }

    //写的方法
    public void write() {
        int cnt = 0;
        while (cnt++ < 3) {
                try {
                writeLock.lock();
                System.out.println(Thread.currentThread().getId() + " start to write");

                int anum = (int) (Math.random() * 10);
               /* num = (int) (Math.random() * 10);
                System.out.println(Thread.currentThread().getId() + " write," + num);*/
                System.out.println(Thread.currentThread().getId() + " write," );
                Thread.sleep(1000);
            } catch (Exception e)
                { e.printStackTrace();}
                finally { writeLock.unlock();}
        }
    }

}
