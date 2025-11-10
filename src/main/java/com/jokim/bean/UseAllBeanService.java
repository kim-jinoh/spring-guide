package com.jokim.bean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseAllBeanService {

    private final List<BeanService> beanServices;
    private final Map<String, BeanService> beanServicesMap;

    public UseAllBeanService(List<BeanService> beanServices, Map<String, BeanService> beanServicesMap) {
        this.beanServices = beanServices;
        this.beanServicesMap = beanServicesMap;
    }

    public List<BeanService> getBeanServices() {
        return beanServices;
    }

    public BeanService getBeanServiceByBeanName(String beanName) {
        return beanServicesMap.get(beanName);
    }
}
