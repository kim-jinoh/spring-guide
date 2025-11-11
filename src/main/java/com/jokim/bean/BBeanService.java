package com.jokim.bean;

import org.springframework.stereotype.Component;

import com.jokim.bean.annotation.BBeanServiceAnnotation;

@Component("bBeanService")
@BBeanServiceAnnotation
public class BBeanService implements BeanService{

    @Override
    public void doSomething() {
        System.out.println("I'm BBeanService");
    }

}
