package com.example.singleton.service;

public class MemberServiceImplSingleton implements MemberService{

    private static final MemberServiceImplSingleton instance = new MemberServiceImplSingleton();        // 1

    private MemberServiceImplSingleton() {}                 // 2

    public static MemberServiceImplSingleton getInstance() {            // 3
        return instance;
    }

    public String singletonStatus() {
        return "싱글톤 적용 완료";
    }
}
