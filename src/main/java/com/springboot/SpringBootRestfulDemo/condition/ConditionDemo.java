package com.springboot.SpringBootRestfulDemo.condition;

/**
 * @author yan
 * @desc ConditionDemo
 * @date 2021/10/31
 */
public class ConditionDemo {
    public static void main(String[] arg){
            Store store=new Store(3);
            ProductThread product=new ProductThread(store);
            ConsumeThread consume=new ConsumeThread(store);

            //2 producer
            for(int i=0;i<2;i++){
                new Thread(product,"producer-"+i).start();
            }

            //2 consumer
            for(int i=0;i<2;i++){
                new Thread(consume,"consumer-"+i).start();
            }
        }

}
