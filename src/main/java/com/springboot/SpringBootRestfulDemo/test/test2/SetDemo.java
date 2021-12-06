package com.springboot.SpringBootRestfulDemo.test.test2;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author yan
 * @desc SetDemo
 * @date 2021/11/26
 */
public class SetDemo {
    public static void main(String[] argus){
        final HashSet<Emp> emps = new HashSet<>();
        Emp e1= new Emp(100);
        Emp e2= new Emp(105);
        Emp e3= new Emp(100);
        Emp e4= new Emp(200);
        emps.add(e1);
        emps.add(e3);
        emps.add(e2);
        emps.add(e4);
        System.out.println("emps.sze is = " + emps.size());

        final Iterator<Emp> iterator = emps.iterator();
        while (iterator.hasNext()){
            final Emp next = iterator.next();
            final int id = next.getId();
            System.out.println("id = " + id);
        }
    }
}
