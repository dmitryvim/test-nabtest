package com.mikhaylovich.nabtest;

public class Person {
    private String name;
    private String phone;

    /**
     * Пустой конструктор необходим, чтобы можно было распарсить json
     */
    protected Person() {
        super();
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "[" + this.name + ": " + this.phone + "]";
    }

    //getter для теста работы JsonMapper
    public String getTest() {
        return "test";
    }
}

