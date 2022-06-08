package com.example.singleton;

import com.example.singleton.repository.MemberRepository;
import com.example.singleton.service.MemberServiceImpl;
import com.example.singleton.service.MemberServiceImplSingleton;
import com.example.singleton.status.StatefulService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberServiceImpl memberServiceImpl() {
        System.out.println("call memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call memberRepository");
        return new MemberRepository();
    }

    @Bean
    public MemberServiceImplSingleton memberServiceSingleton() {
        return MemberServiceImplSingleton.getInstance();
    }

    @Bean
    public StatefulService statefulService() {
        return new StatefulService();
    }
}
