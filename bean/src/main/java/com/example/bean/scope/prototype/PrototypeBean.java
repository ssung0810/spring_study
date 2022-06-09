package com.example.bean.scope.prototype;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
public class PrototypeBean {

    private int count = 0;

    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @PostConstruct
    public void init() {
        System.out.println("PrototypeClient.init " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("PrototypeClient.close " + this);
    }
}
