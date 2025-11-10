package com.jokim.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("aBeanService")
@Qualifier("aBeanService")
public class ABeanService implements BeanService{

    @Override
    public void doSomething() {
        System.out.println("I'm ABeanService");
    }
}
