package com.example.singleton.component.service;

import org.springframework.stereotype.Component;

@Component
public class C_MemberServiceImplSingleton implements C_MemberService {

    private static final C_MemberServiceImplSingleton instance = new C_MemberServiceImplSingleton();        // 1

    private C_MemberServiceImplSingleton() {}                 // 2

    public static C_MemberServiceImplSingleton getInstance() {            // 3
        return instance;
    }

    public String singletonStatus() {
        return "싱글톤 적용 완료";
    }
}
