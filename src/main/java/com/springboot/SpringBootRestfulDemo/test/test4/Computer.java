package com.springboot.SpringBootRestfulDemo.test.test4;

import java.lang.reflect.Field;

/**
 * @author yan
 * @desc Computer
 * @date 2021/11/26
 */
public class Computer extends BaseItem{
    private float price;
    private String useTerm;

    public Computer() {
    }

    public Computer(final float price, final String useTerm, String inputTime, String operator) {
        this.price = price;
        this.useTerm = useTerm;
        super.inputTime = inputTime;
        super.operator = operator;
    }

    @Override
    public String print() {
        System.out.println("price = " + price);
        System.out.println("useTerm = " + useTerm);
        System.out.println("inputTime = " + inputTime);
        System.out.println("operator = " + operator);
        return "name";
    }

    @Override
    public String print(Computer c, String name) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Computer>  clazz = Computer.class;
         Field declaredField = null;
        try {
            declaredField = clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            final Class<? super Computer> superclass = clazz.getSuperclass();
            declaredField = superclass.getDeclaredField(name);
        }
        System.out.println("name = " + declaredField.getName());
        try {

            final Object o = declaredField.get(c);
            System.out.println("value = " + o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static void main(String[] args) {
        final Computer jack = new Computer(100.0f, "3", "1000", "Jack");
        try {
            final String price = jack.print(jack,"inputTime");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
