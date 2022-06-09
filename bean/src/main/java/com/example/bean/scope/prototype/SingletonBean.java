package com.example.bean.scope.prototype;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonBean {

    @Autowired
    private ObjectProvider<PrototypeBean> prototypeClientProvider;

    public int logic() {
        PrototypeBean prototypeClient = prototypeClientProvider.getObject();
        prototypeClient.addCount();
        return prototypeClient.getCount();
    }

    @PostConstruct
    public void init() {
        System.out.println("SingletonClient.init " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("SingletonClient.close " + this);
    }
}
