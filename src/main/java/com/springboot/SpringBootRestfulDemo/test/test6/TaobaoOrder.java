package com.springboot.SpringBootRestfulDemo.test.test6;

import java.lang.reflect.Field;

/**
 * @author yan
 * @desc TaobaoOrder
 * @date 2021/11/26
 */
public class TaobaoOrder extends BaseOrder{
    public float price;
    public String name;

    public TaobaoOrder() {
    }

    public TaobaoOrder(final float price, final String name,  String createdTime,  String operator) {
        this.price = price;
        this.name = name;
        super.createdTime = createdTime;
        super.operator = operator;
    }

    @Override
    public void displayOrder() {
        System.out.println("price = " + price);
        System.out.println("name = " + name);
        System.out.println("createdTime = " + createdTime);
        System.out.println("operator = " + operator);
    }

    @Override
    public void displayOrder(String name) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<TaobaoOrder> clazz = TaobaoOrder.class;
        final TaobaoOrder taobaoOrder = (TaobaoOrder) clazz.newInstance();

        Field declaredField;
        try {
            declaredField = clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            declaredField = clazz.getSuperclass().getDeclaredField(name);
        }

        final String fieldName = declaredField.getName();
        System.out.println("fieldName = " + fieldName);

        final Object o = declaredField.get(taobaoOrder);
        System.out.println("o = " + o);
    }
}
