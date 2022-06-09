package hello.spring_mvc_study.web.frontcontroller.v5;

import hello.spring_mvc_study.web.frontcontroller.ModelView;
import hello.spring_mvc_study.web.frontcontroller.MyView;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.spring_mvc_study.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.spring_mvc_study.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.spring_mvc_study.web.frontcontroller.v5.adaptor.ControllerV3HandlerAdapter;
import hello.spring_mvc_study.web.frontcontroller.v5.adaptor.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServiceV5 extends HttpServlet {

    private Map<String, Object> handlerMappingMap = new HashMap<>();
    private List<MyHandleAdapter> handleAdapters = new ArrayList<>();

    public FrontControllerServiceV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handleAdapters.add(new ControllerV3HandlerAdapter());
        handleAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandleAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(request, response, handler);
        MyView view = viewResolver(mv);

        view.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyHandleAdapter getHandlerAdapter(Object handler) {
        for (MyHandleAdapter adapter : handleAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = " + handler);
    }

    private MyView viewResolver(ModelView mv) {
        return new MyView("/WEB-INF/views/" + mv.getViewName() + ".jsp");
    }
}
