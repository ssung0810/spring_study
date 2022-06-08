package com.example.bean.prototype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void 싱글톤_내부에_생성된_프로토_타입() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeConfig.class);

        SingletonClient singletonClient1 = ac.getBean("singletonClient", SingletonClient.class);
        int count1 = singletonClient1.logic();
        assertThat(count1).isEqualTo(1);

        SingletonClient singletonClient2 = ac.getBean("singletonClient", SingletonClient.class);
        int count2 = singletonClient2.logic();
        assertThat(count2).isEqualTo(1);
    }


    @Test
    void providerTest() {
        AnnotationConfigApplicationContext ac = new
                AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }
    static class ClientBean {
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("ClientBean.init " + this);
        }

        @PreDestroy
        public void close() {
            System.out.println("ClientBean.close " + this);
        }
    }
    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;
        public void addCount() {
            count++;
        }
        public int getCount() {
            return count;
        }
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
