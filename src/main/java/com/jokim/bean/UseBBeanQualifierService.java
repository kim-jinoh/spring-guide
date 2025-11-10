package com.jokim.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UseBBeanQualifierService implements QualifierService {

    private final BeanService beanService;

    @Autowired
    public UseBBeanQualifierService(@Qualifier("bBeanService") BeanService beanService) {
        this.beanService = beanService;
    }

    public BeanService getBeanService() {
        return beanService;
    }
}
