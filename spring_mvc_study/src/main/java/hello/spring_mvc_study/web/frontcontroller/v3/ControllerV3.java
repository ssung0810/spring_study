package hello.spring_mvc_study.web.frontcontroller.v3;

import hello.spring_mvc_study.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    public ModelView process(Map<String, String> paramMap);
}
