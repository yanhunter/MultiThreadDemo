package com.springboot.SpringBootRestfulDemo.test.test3;

import java.util.HashMap;

/**
 * @author yan
 * @desc User
 * @date 2021/11/26
 */
public class User {
    private int id;

    public User(final int id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {
        final User user1 = new User(1);
        final User user2 = new User(1);
        final HashMap userHashMap = new HashMap<User, String>();
        userHashMap.put(user1,"100");
        final boolean b1 = userHashMap.containsKey(user1);
        if(b1){
            System.out.println("v1 = " + userHashMap.get(user1));
        }
        final boolean b2 = userHashMap.containsKey(user2);
        if(b2){
            System.out.println("v2 = " + userHashMap.get(user2));
        }

        final int size = userHashMap.size();
        System.out.println("size = " + size);


    }
}
