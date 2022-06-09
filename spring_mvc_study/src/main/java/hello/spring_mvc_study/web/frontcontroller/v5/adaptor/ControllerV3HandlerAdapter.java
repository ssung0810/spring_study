package hello.spring_mvc_study.web.frontcontroller.v5.adaptor;

import hello.spring_mvc_study.web.frontcontroller.ModelView;
import hello.spring_mvc_study.web.frontcontroller.MyView;
import hello.spring_mvc_study.web.frontcontroller.v3.ControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v5.MyHandleAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandleAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParam(request);
        ModelView mv = controller.process(paramMap);

        return mv;
    }

    private Map<String, String> createParam(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
