package com.jokim.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ScopeTests {

    private static final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class, PrototypeBean.class);

    @Test
    @DisplayName("[Success]Singleton Scope 테스트")
    void singletonScopeTest() {
        // arrange & act
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        
        // assert
        assertThat(singletonBean1).isSameAs(singletonBean2);
    }
    
    @Test
    @DisplayName("[Success]Prototype Bean은 다름")
    void prototypeBeanTest() {
        // arrange
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        
        // assert
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
    }
    
    @Test
    @DisplayName("[Success]Singleton Bean에 주입된 Prototype Bean은 같음")
    void singletonBeanTestWithPrototype() {
        // arrange
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        // act
        PrototypeBean prototypeBean1 = singletonBean1.getPrototypeBean();
        PrototypeBean prototypeBean2 = singletonBean2.getPrototypeBean();

        // assert
        assertThat(prototypeBean1).isSameAs(prototypeBean2);
    }





    @Scope(value = "singleton")
    static class SingletonBean {
        private final PrototypeBean prototypeBean;

        @Autowired
        public SingletonBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public PrototypeBean getPrototypeBean() {
            return prototypeBean;
        }
    }

    @Scope(value = "prototype")
    static class PrototypeBean {
    
    }
}
