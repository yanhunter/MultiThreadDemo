package com.springboot.SpringBootRestfulDemo.test.test5;

/**
 * @author yan
 * @desc CalCircleShape
 * @date 2021/11/26
 */
public class CalCircleShape extends EmptyClass {

    @Override
    public float calShape(final float name) {
        return  PI * name * name ;
    }

    public static void main(String[] args) {
        CalCircleShape calCircleShape = new CalCircleShape();
        final float v = calCircleShape.calShape(4);
        System.out.println("v = " + v);
    }
}
