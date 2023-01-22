package dev.danvega.model.Menu;

import java.util.List;

public class AppMenu {
    private Integer app_id;
    private String app_name;

    private List<AppFunctionMenu> functions;

    public AppMenu() {
    }

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

    public List<AppFunctionMenu> getFunctions() {
        return functions;
    }

    public void setFunctions(List<AppFunctionMenu> functions) {
        this.functions = functions;
    }
}
