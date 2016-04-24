package com.mikhaylovich.nabtest.service;

import com.mikhaylovich.nabtest.model.Person;
import com.mikhaylovich.nabtest.util.JsonMapper;

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
