package com.springboot.SpringBootRestfulDemo.test.test4;

/**
 * @author yan
 * @desc BaseItem
 * @date 2021/11/26
 */
public abstract class BaseItem {
    public String inputTime;
    public String operator;

    public String print(){
        return "";
    }

    public String print(String name) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return name;
    }

    public abstract String print(Computer c, String name) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
