package com.example.singleton.status;

import com.example.singleton.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void 싱글톤_패턴_상태유지() throws Exception {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // when
        statefulService1.order("UserA", 10000);
        statefulService2.order("UserB", 20000);
        int price = statefulService1.getPrice();

        // then
        System.out.println("price = " + price);
        Assertions.assertThat(price).isNotEqualTo(10000);
    }

    @Test
    void 싱글톤_패턴_무상태() throws Exception {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // when
        int userAPrice = statefulService1.order("UserA", 10000);
        int userBPrice = statefulService2.order("UserB", 20000);

        // then
        System.out.println("price = " + userAPrice);
        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }
}