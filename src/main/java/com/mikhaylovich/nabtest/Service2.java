package com.mikhaylovich.nabtest;

/**
 * @author mhty
 * @date 17.04.16.
 */
public class Service2 {
    private Person person;

    public Service2() {
        this.person = new Person("МЧС", "112");
    }

    public String getPersonJson() {
        return JsonMapper.convertToJson(this.person);
    }
}
