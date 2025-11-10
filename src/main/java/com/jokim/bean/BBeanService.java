package com.jokim.bean;

import org.springframework.stereotype.Component;

@Component("bBeanService")
public class BBeanService implements BeanService{

    @Override
    public void doSomething() {
        System.out.println("I'm BBeanService");
    }

}
