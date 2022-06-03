package com.example.singleton;

import com.example.singleton.service.MemberService;
import com.example.singleton.service.MemberServiceSingleton;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void 두_개의_객체_생성_싱글톤_적용_안함() throws Exception {
        // given
        MemberService memberService1 = new MemberService();
        MemberService memberService2 = new MemberService();

        // when, then
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void 두_개의_객체_생성_싱글톤_적용_완료() throws Exception {
        // given
        MemberServiceSingleton memberServiceSingleton1 = MemberServiceSingleton.getInstance();
        MemberServiceSingleton memberServiceSingleton2 = MemberServiceSingleton.getInstance();

        // when, then
        System.out.println("memberServiceSingleton1 = " + memberServiceSingleton1);
        System.out.println("memberServiceSingleton2 = " + memberServiceSingleton2);

        assertThat(memberServiceSingleton1).isSameAs(memberServiceSingleton2);
    }
}
