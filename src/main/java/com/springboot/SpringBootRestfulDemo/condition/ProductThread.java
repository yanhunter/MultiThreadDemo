package com.springboot.SpringBootRestfulDemo.condition;

/**
 * @author yan
 * @desc ProductThread
 * @date 2021/10/31
 */
public class ProductThread implements Runnable{
    private Store store;

	    public ProductThread(Store store)
	    {  	this.store=store;    }

	    public void run() {
            while(true)
            {  	store.product();  }
        }

}
