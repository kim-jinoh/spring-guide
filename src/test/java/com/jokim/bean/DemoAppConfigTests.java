package com.jokim.bean;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class DemoAppConfigTests {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoAppConfig.class);

    @Test
    @DisplayName("[Success]aBeanService, bBeanService 메서드 명으로 꺼내기")
    void getServicesByMethodNames() {
        // arrange & act
        BeanService aBeanService = ac.getBean("aBeanService", BeanService.class);
        BeanService bBeanService = ac.getBean("bBeanService", BeanService.class);

        // assert
        assertThat(aBeanService).isInstanceOf(ABeanService.class);
        assertThat(bBeanService).isInstanceOf(BBeanService.class);
    }

    @Test
    @DisplayName("[Fail]BeanService 타입으로 꺼내기")
    void getServicesByInterfaceTypeThrowsNoUniqueBeanDefinitionException() {
        // arrange & act & assert
        assertThatThrownBy(() -> ac.getBean(BeanService.class))
            .isInstanceOf(NoUniqueBeanDefinitionException.class);
    }
    
    @Test
    @DisplayName("[Success]BeanService 타입으로 전부 꺼내기")
    void getServicesByInterfaceType() {
        // arrange & act
        Map<String, BeanService> beanServices = ac.getBeansOfType(BeanService.class);

        // assert
        for (BeanService beanService : beanServices.values()) {
            assertThat(beanService).isInstanceOf(BeanService.class);
        }
        assertThat(beanServices).hasSize(2);
    }

    @Test
    @DisplayName("[Success]ABeanService, BBeanService 타입으로 꺼내기")
    void getServiceByType() {
        // arrange & act
        BeanService aBeanService = ac.getBean(ABeanService.class);
        BeanService bBeanService = ac.getBean(BBeanService.class);

        // assert
        assertThat(aBeanService).isInstanceOf(ABeanService.class);
        assertThat(bBeanService).isInstanceOf(BBeanService.class);
    }
}
