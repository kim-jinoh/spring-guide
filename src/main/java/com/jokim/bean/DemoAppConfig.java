package com.jokim.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoAppConfig {

    @Bean
    public BeanService aBeanService() {
        return new ABeanService();
    }

    @Bean
    public BeanService bBeanService() {
        return new BBeanService();
    }
}
