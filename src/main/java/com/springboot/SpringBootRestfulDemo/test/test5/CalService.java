package com.springboot.SpringBootRestfulDemo.test.test5;

/**
 * @author yan
 * @desc CalService
 * @date 2021/11/26
 */
public interface CalService {
    public static final float PI = 3.14f;
    public static final float G = 9.8f;

    public float calShape (float name);
    public float calGravity (float name);
}
