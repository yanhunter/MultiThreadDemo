package com.springboot.SpringBootRestfulDemo.test.test5;

/**
 * @author yan
 * @desc EmptyClass
 * @date 2021/11/26
 */
public class EmptyClass implements CalService {
    @Override
    public float calShape(final float name) {
        return 0;
    }

    @Override
    public float calGravity(final float name) {
        return 0;
    }
}
