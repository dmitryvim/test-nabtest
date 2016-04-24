package com.mikhaylovich.nabtest.service;

import com.google.inject.ProvidedBy;
import com.mikhaylovich.nabtest.model.Person;
import com.mikhaylovich.nabtest.util.JsonMapper;

/**
 * @author mhty
 * @date 24.04.16.
 */
@ProvidedBy(Service3Provider.class)
public class Service3 {
    private Person person;

    public Service3(Person person) {
        this.person = person;
    }

    public String getPersonJson() {
        return JsonMapper.convertToJson(this.person);
    }
}
