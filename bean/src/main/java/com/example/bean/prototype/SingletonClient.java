package com.example.bean.prototype;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonClient {

    @Autowired
    private ObjectProvider<PrototypeClient> prototypeClientProvider;

    public int logic() {
        PrototypeClient prototypeClient = prototypeClientProvider.getObject();
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
