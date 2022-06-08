package com.example.bean.prototype;

import com.example.bean.scope.ScopeConfig;
import com.example.bean.scope.prototype.SingletonBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void 싱글톤_내부에_생성된_프로토_타입() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScopeConfig.class);

        SingletonBean singletonClient1 = ac.getBean(SingletonBean.class);
        int count1 = singletonClient1.logic();
        assertThat(count1).isEqualTo(1);

        SingletonBean singletonClient2 = ac.getBean(SingletonBean.class);
        int count2 = singletonClient2.logic();
        assertThat(count2).isEqualTo(1);
    }
}
