package com.jokim.bean;

public class ABeanService implements BeanService{

    @Override
    public void doSomething() {
        System.out.println("I'm ABeanService");
    }
}
