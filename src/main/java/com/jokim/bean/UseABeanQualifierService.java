package com.jokim.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UseABeanQualifierService {

    private final BeanService beanService;

    @Autowired
    public UseABeanQualifierService(@Qualifier("aBeanService") BeanService beanService) {
        this.beanService = beanService;
    }

    public BeanService getBeanService() {
        return beanService;
    }
}
