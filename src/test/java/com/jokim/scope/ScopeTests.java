package com.jokim.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

public class ScopeTests {

    private static final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        SingletonBean.class, PrototypeBean.class, PrototypeProxyModeBean.class
        );

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

    @Test
    @DisplayName("[Success]Singleton Bean에서 Provider로 Prototype Bean 조회 테스트")
    void singletonBeanTestWithPrototypeFromProvider() {
        // arrange
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        // act
        PrototypeBean prototypeBean1 = singletonBean1.getPrototypeBeanFromProvider();
        PrototypeBean prototypeBean2 = singletonBean2.getPrototypeBeanFromProvider();

        // assert
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
    }

    @Test
    @DisplayName("[Success]Singleton Bean에서 Provider로 Prototype Bean 조회 테스트")
    void singletonBeanTestWithPrototypeProxyModeBean() {
        // arrange
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        
        // act
        PrototypeProxyModeBean prototypeProxyModeBean1 = singletonBean1.getPrototypeProxyModeBean();
        PrototypeProxyModeBean prototypeProxyModeBean2 = singletonBean2.getPrototypeProxyModeBean();

        // assert
        assertThat(prototypeProxyModeBean1.hashCode()).isNotSameAs(prototypeProxyModeBean2.hashCode());
    }


    @Scope(value = "singleton")
    static class SingletonBean {
        private final PrototypeBean prototypeBean;
        private final ObjectProvider<PrototypeBean> prototypeBeanProvider;
        private final PrototypeProxyModeBean prototypeProxyModeBean;

        @Autowired
        public SingletonBean(PrototypeBean prototypeBean, ObjectProvider<PrototypeBean> prototypeBeanProvider, PrototypeProxyModeBean prototypeProxyModeBean) {
            this.prototypeBean = prototypeBean;
            this.prototypeBeanProvider = prototypeBeanProvider;
            this.prototypeProxyModeBean = prototypeProxyModeBean;
        }

        public PrototypeBean getPrototypeBean() {
            return prototypeBean;
        }

        public PrototypeBean getPrototypeBeanFromProvider() {
            return prototypeBeanProvider.getObject();
        }

        public PrototypeProxyModeBean getPrototypeProxyModeBean() {
            prototypeProxyModeBean.doSomething();
            return prototypeProxyModeBean;
        }
    }

    @Scope(value = "prototype")
    static class PrototypeBean {
    
    }

    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    static class PrototypeProxyModeBean {
        private int count = 0;
        public void doSomething() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
