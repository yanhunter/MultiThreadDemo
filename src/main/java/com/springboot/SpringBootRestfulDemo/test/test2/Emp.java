package com.springboot.SpringBootRestfulDemo.test.test2;

/**
 * @author yan
 * @desc Emp
 * @date 2021/11/26
 */
public class Emp {

    private int id;

    public Emp(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Emp emp = (Emp) o;

        return id == emp.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
