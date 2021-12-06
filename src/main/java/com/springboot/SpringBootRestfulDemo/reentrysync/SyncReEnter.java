package com.springboot.SpringBootRestfulDemo.reentrysync;

/**
 * @author yan
 * @desc SyncReEnter
 * @date 2021/11/15
 */
public class SyncReEnter implements Runnable {
    public synchronized void get(){
         System.out.print(Thread.currentThread().getId() + "\t");
          //在get方法里调用set
          set();
    }
    public synchronized void set()
    {System.out.print(Thread.currentThread().getId()+"\t"); }

    public void run() //run方法里调用了get方法
    { get();}

}
