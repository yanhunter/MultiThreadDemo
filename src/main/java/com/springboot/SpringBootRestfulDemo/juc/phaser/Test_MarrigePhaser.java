package com.springboot.SpringBootRestfulDemo.juc.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 *  Step1: all
 *  Step2: all
 *  Step3: all
 *  Step4: only 新郎, 新娘
 * @author yan
 * @desc MarrigePhaser
 * @date 2021/12/1
 */
public class Test_MarrigePhaser {

    static Random random = new Random();
    static Marriage marriagePhase=new Marriage();

    static void milliSleep(int mill){
        try {
            TimeUnit.MILLISECONDS.sleep(mill);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        marriagePhase.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p"+ i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }

    static class Person implements Runnable{
        String name;
        public Person() {}
        public Person(String name) {
            this.name = name;
        }

        public void arrive(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 到达现场 ", name);
            System.out.println();
            marriagePhase.arriveAndAwaitAdvance();
        }
        public void eat(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 吃完 ", name);
            System.out.println();
            marriagePhase.arriveAndAwaitAdvance();
        }
        public void leave(){
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 离开 ", name);
            System.out.println();
            marriagePhase.arriveAndAwaitAdvance();
        }
        public void hug(){
            if(name.equals("新郎") || name.equals("新娘")){
                milliSleep(random.nextInt(1000));
                System.out.printf("%s 洞房 ", name);
                System.out.println();
                marriagePhase.arriveAndAwaitAdvance();
            }else {
                marriagePhase.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }

    static class Marriage extends Phaser{
        @Override
        protected boolean onAdvance(final int phase, final int registeredParties) {

            switch (phase){
                //phase should be start wth 0, 1 , ...
                case 0:
                    System.out.println("所有人到齐 "+ registeredParties);
                    return false;
                case 1:
                    System.out.println("所有人吃完了 "+ registeredParties);
                    return false;
                case 2:
                    System.out.println("所有人离开了 "+ registeredParties);
                    return false;
                case 3:
                    System.out.println("婚礼结束! 新郎新娘拥抱 "+ registeredParties);
                    return false;
                default:
                    return true;
            }
        }
    }
}
