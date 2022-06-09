package hello.spring_mvc_study.web.frontcontroller.v3;

import hello.spring_mvc_study.web.frontcontroller.ModelView;
import hello.spring_mvc_study.web.frontcontroller.MyView;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.spring_mvc_study.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServiceV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServiceV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServiceV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        MyView view = getViewName(mv.getViewName());
        view.render(mv.getModel(), request, response);
    }

    private MyView getViewName(String viewPath) {
        MyView view = new MyView("/WEB-INF/views/" + viewPath + ".jsp");
        return view;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
