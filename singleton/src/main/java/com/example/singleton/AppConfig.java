package com.example.singleton;

import com.example.singleton.service.MemberServiceImpl;
import com.example.singleton.service.MemberServiceImplSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberServiceImpl memberService() {
        return new MemberServiceImpl();
    }

    @Bean
    public MemberServiceImplSingleton memberServiceSingleton() {
        return MemberServiceImplSingleton.getInstance();
    }
}
