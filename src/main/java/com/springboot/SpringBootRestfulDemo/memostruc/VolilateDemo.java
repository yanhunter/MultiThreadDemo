package com.springboot.SpringBootRestfulDemo.memostruc;

/**
 * @author yan
 * @desc VolilateDemo
 * @date 2021/11/17
 */
public class VolilateDemo extends Thread{
    //启动1000个线程，对这个被volatile修饰的变量进行加1操作
	    public static volatile int cnt = 0;

		public static void add() {
			// 延迟1毫秒，增加多线程并发抢占的概率
			try { Thread.sleep(1);}
	        catch (InterruptedException e) {	}
			cnt++;//加操作
		}

		public static void main(String[] args) {
		// 同时启动1000个线程，去进行加操作
		for (int i = 0; i < 1000; i++) {
				new Thread(new Runnable() {
                    public void run()
                   {VolilateDemo.add();	}
	            }).start();
		}

		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("Result is " + VolilateDemo.cnt);
	}

}
