package com.jokim.aop;

import org.springframework.stereotype.Service;

@Service
public class SimpleAopService implements AopService {

    @Override
    public void create() {
        System.out.println("create");
    }

    @Override
    @BeforeMethodByAnnotation
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
