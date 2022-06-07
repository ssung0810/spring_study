package com.example.singleton;

import com.example.singleton.repository.MemberRepository;
import com.example.singleton.service.MemberService;
import com.example.singleton.service.MemberServiceImpl;
import com.example.singleton.service.MemberServiceImplSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void 두_개의_객체_생성_싱글톤_적용_안함() throws Exception {
        // given
        AppConfig appConfig = new AppConfig();
        MemberServiceImpl memberService1 = appConfig.memberServiceImpl();
        MemberServiceImpl memberService2 = appConfig.memberServiceImpl();

        // when, then
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void 두_개의_객체_생성_싱글톤_적용_완료() throws Exception {
        // given
        AppConfig appConfig = new AppConfig();
        MemberServiceImplSingleton memberServiceSingleton1 = appConfig.memberServiceSingleton();
        MemberServiceImplSingleton memberServiceSingleton2 = appConfig.memberServiceSingleton();

        // when, then
        System.out.println("memberServiceSingleton1 = " + memberServiceSingleton1);
        System.out.println("memberServiceSingleton2 = " + memberServiceSingleton2);

        assertThat(memberServiceSingleton1).isSameAs(memberServiceSingleton2);
    }

    @Test
    void Spring을_사용한_싱글톤_적용() throws Exception {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService1 = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
        MemberServiceImpl memberService2 = ac.getBean("memberServiceImpl", MemberServiceImpl.class);

        // when, then
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    void Configuration_테스트() throws Exception {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass());

//        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
    }
}
