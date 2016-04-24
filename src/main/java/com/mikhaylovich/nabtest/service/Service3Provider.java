package com.mikhaylovich.nabtest.service;

import com.google.inject.Provider;
import com.mikhaylovich.nabtest.model.Person;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author mhty
 * @date 24.04.16.
 */
public class Service3Provider implements Provider<Service3> {
    @Inject
    @Named("provider.name")
    private String name;

    @Inject
    @Named("provider.phone")
    private String phone;

    private Service3 service3() {
        return new Service3(new Person(name, phone));
    }

    public Service3 get() {
        return service3();
    }
}
