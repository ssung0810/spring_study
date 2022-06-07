package com.example.singleton.component.service;

import org.springframework.stereotype.Component;

@Component
public class C_MemberServiceImpl implements C_MemberService {

//    private final MemberRepository memberRepository;
//
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    public String singletonStatus() {
        return "싱글톤 적용안됨";
    }
}
