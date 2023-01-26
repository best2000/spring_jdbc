package dev.danvega.model.Menu;

import java.util.List;

public class AppMenu {
    private String app_code;
    private String app_name;
    private List<FunctionMenu> functions;

    public AppMenu(String app_code, String app_name, List<FunctionMenu> functions) {
        this.app_code = app_code;
        this.app_name = app_name;
        this.functions = functions;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public List<FunctionMenu> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionMenu> functions) {
        this.functions = functions;
    }
}