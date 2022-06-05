package com.example.singleton.service;

import com.example.singleton.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String singletonStatus() {
        return "싱글톤 적용안됨";
    }
}
