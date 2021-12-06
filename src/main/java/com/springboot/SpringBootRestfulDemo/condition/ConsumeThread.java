package com.springboot.SpringBootRestfulDemo.condition;

/**
 * @author yan
 * @desc ConsumeThread
 * @date 2021/10/31
 */
public class ConsumeThread implements Runnable{
    	private Store store;
		public ConsumeThread(Store store)
	    { this.store=store;   }
	    public void run() {
            while(true){
                store.consume();
            }
		}
}
