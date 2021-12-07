package com.springboot.SpringBootRestfulDemo.threadorder;

/**
 * @author yan
 * @desc TestThreadOrder
 * @date 2021/12/6
 */
public class TestThreadOrder {

    static int x,y,a,b;

    public static void main(String[] args) throws InterruptedException {
        int i  = 0 ;
        for (;;){
            i ++;
            x=0; y=0;
            a=0; b=0;

            final Thread threadA = new Thread(()->{
                a=1;
                x=b;
            });
            final Thread threadB = new Thread(()->{
                b=1;
                y=a;
            });

            threadA.start();
            threadB.start();


            threadA.join();
            threadB.join();

            String result = "?" + i+ "? ("+x+","+y+") ."; // ?274906? (0,0) .  ; ?616559? (0,0) .

            if(x==0 && y ==0){
                System.err.println(result);
                break;
            }else {

            }
        }
    }
}
