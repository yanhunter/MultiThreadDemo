package com.springboot.SpringBootRestfulDemo.memostruc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yan
 * @desc ThreadSafeDemo
 * @date 2021/11/16
 */
public class ThreadSafeDemo {
    public static int addByThreads(final List list, String type) {
        //创建一个线程组
        ThreadGroup group = new ThreadGroup(type);

        //通过内部类的方法来创建多线程
        Runnable listAddTool = new Runnable() {
            public void run() {//在其中定义线程的主体代码
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("0");  //在集合里添加元素
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //启动10000个线程，同时向集合里添加元素
        for (int i = 0; i < 10000; i++) {
            new Thread(group, listAddTool).start();
        }

        // 多个线程组之间sleep10毫秒，以免相互干扰
        while (group.activeCount() > 0) {
            try {
                System.out.println("group.activeCount() = " + group.activeCount());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return list.size(); //返回插入后的集合长度
    }

    public static void main(String[] args) {
    //ArrayList是线程不安全的
      List unsafeList = new ArrayList();
      List safeList = Collections.synchronizedList(new ArrayList());//包装成线程安全的
    //运行3次
      for (int i = 0; i < 3; i++) {
            unsafeList.clear();
            safeList.clear();
            int unsafeSize = addByThreads(unsafeList, "unsafe");
            int safeSize = addByThreads(safeList, "safe");
            System.out.println("unsafe/safe: "+unsafeSize+"/" + safeSize);
      }
    }

}
