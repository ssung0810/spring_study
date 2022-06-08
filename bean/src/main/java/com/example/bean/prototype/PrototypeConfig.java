package com.example.bean.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeConfig {

    @Bean
    public SingletonClient singletonClient() {
        return new SingletonClient();
    }

    @Bean
    @Scope("prototype")
    public PrototypeClient prototypeClient() {
        return new PrototypeClient();
    }
}
