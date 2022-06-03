package com.example.singleton.service;

public class MemberServiceSingleton {

    private static final MemberServiceSingleton instance = new MemberServiceSingleton();

    private MemberServiceSingleton() {

    }

    public static MemberServiceSingleton getInstance() {
        return instance;
    }

    public String save() {
        return "싱글톤 적용 완료";
    }
}
