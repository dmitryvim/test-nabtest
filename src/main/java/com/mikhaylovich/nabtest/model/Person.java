package com.mikhaylovich.nabtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private String name;
    private String phone;
    @JsonProperty("property")
    private String nonProp;

    /**
     * Пустой конструктор необходим, чтобы можно было распарсить json
     */
    protected Person() {
        super();
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.nonProp = "nonProp";
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

    public String getNonProp() {
        return this.nonProp;
    }
}

