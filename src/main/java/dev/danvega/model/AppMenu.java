package dev.danvega.model;

import java.util.ArrayList;
import java.util.List;

public class AppMenu {
    private Integer app_id;
    private String app_name;

    private List<AppFunction> functions;

    public AppMenu(Integer app_id, String app_name) {
        this.app_id = app_id;
        this.app_name = app_name;
//        this.functions = functions;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public List<AppFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<AppFunction> functions) {
        this.functions = functions;
    }
}
