package com.springboot.SpringBootRestfulDemo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author yan
 * @desc SemaphoreDemo
 * @date 2021/10/31
 */
public class SemaphoreDemo {
    	public static void main(String[] args) {
    			ConnectionProvide provider = new ConnectionProvide();
    	        Semaphore semaphore = new Semaphore(2,true);
    	        for(int i=0;i<5;i++){
    	        	new HandleUserThread(Integer.valueOf(i).toString(),semaphore,provider).start();
    	        }
    	}

}
