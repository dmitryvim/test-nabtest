package com.mikhaylovich.nabtest;

/**
 * @author mhty
 * @date 16.04.16.
 */
public class Person {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Person(String name, String phone) {

        this.name = name;
        this.phone = phone;
    }
}
