package com.springboot.SpringBootRestfulDemo.test.test5;

/**
 * @author yan
 * @desc CalGravityService
 * @date 2021/11/26
 */
public class CalGravityService extends  EmptyClass{
    @Override
    public float calGravity(final float name) {
        return G*name;
    }
}
