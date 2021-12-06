package com.springboot.SpringBootRestfulDemo.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan
 * @desc Store
 * @date 2021/10/31
 */
public class Store {
	private  Lock lock;
	private  Condition producerQueue;
    private  Condition consumeQueue;
	private int maxSize;
	private LinkedList<String> storage;

	    //在构造函数里，通过lock对象创建了两个Condition对象
		public Store(int maxSize) {
		lock=new ReentrantLock();
			producerQueue =lock.newCondition();
			consumeQueue =lock.newCondition();
			this.maxSize = maxSize;
			storage = new LinkedList<String>();
		}

		// 生产方法
		public void product() {
			lock.lock();
			try {
				//如果仓库满了
				while (storage.size() == maxSize ){
					  System.out.println (Thread.currentThread().getName()+":wait");
					  //阻塞生产线程
						producerQueue.await();
				 }
				storage.add("Java Book");
				System.out.println(Thread.currentThread().getName()+": put:"+storage.size());
				Thread.sleep(1000);
				//唤醒消费线程
				consumeQueue.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}

		// 消费方法
		public void consume() {
			lock.lock();
			try {
				//如果仓库空了
				while (storage.size() ==0 ){
					System.out.println (Thread.currentThread().getName()+":wait");
					consumeQueue.await();//阻塞消费线程
				}
				//取出消费
				System.out.println(Thread.currentThread().getName()+" consume : "+storage.poll());
				System.out.println (Thread.currentThread().getName()+": left:"+storage.size());
				Thread.sleep(1000);
				producerQueue.signalAll();//唤醒生产线程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}

		}

}
