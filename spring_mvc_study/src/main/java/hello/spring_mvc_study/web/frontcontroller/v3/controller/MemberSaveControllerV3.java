package hello.spring_mvc_study.web.frontcontroller.v3.controller;

import hello.spring_mvc_study.domain.member.Member;
import hello.spring_mvc_study.domain.member.MemberRepository;
import hello.spring_mvc_study.web.frontcontroller.ModelView;
import hello.spring_mvc_study.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = memberRepository.save(new Member(username, age));

        ModelView mv = new ModelView("save");
        mv.getModel().put("member", member);

        return mv;
    }
}
