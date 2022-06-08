package com.example.bean.scope;

import com.example.bean.scope.prototype.PrototypeBean;
import com.example.bean.scope.prototype.SingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
public class ScopeConfig {

    @Bean
    public SingletonBean singletonClient() {
        return new SingletonBean();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeClient() {
        return new PrototypeBean();
    }
}
