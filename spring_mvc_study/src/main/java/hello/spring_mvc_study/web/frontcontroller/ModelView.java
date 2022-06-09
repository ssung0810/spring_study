package hello.spring_mvc_study.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private String ViewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String ViewName) {
        this.ViewName = ViewName;
    }

    public String getViewName() {
        return ViewName;
    }

    public void setViewName(String viewName) {
        ViewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
