package com.springboot.SpringBootRestfulDemo.test.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yan
 * @desc Demo
 * @date 2021/11/26
 */
public class Demo {

    public static void main(String[] argus){
        List<String> list = new ArrayList<>(100);
        list.add("Peter");
        list.add("Tom");
        list.add("Mike");
        list.add("Tim");
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            final String next = iterator.next();
            System.out.println("next = " + next);
        }

        System.out.println("============= " );

        final LinkedList<String> sortedStudentList = new LinkedList<>();
        sortedStudentList.add("Mike");
        sortedStudentList.add("Peter");
        sortedStudentList.add("Tim");
        sortedStudentList.add("Tom");

        final Iterator<String> iterator1 = sortedStudentList.iterator();
        while (iterator1.hasNext()){
            final String next = iterator1.next();
            System.out.println("next = " + next);
        }
    }

}
