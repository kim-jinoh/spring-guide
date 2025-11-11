package com.jokim.bean;

import org.springframework.stereotype.Component;

import com.jokim.bean.annotation.ABeanServiceAnnotation;

@Component("aBeanService")
@ABeanServiceAnnotation
public class ABeanService implements BeanService{

    @Override
    public void doSomething() {
        System.out.println("I'm ABeanService");
    }
}
