package com.example.singleton.service;

import com.example.singleton.repository.MemberRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public String singletonStatus() {
        return "싱글톤 적용안됨";
    }
}
