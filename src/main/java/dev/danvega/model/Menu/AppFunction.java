package dev.danvega.model.Menu;

public class AppFunction {
    private String app_name;
    private String app_code;
    private String function_name;
    private String function_code;

    public AppFunction(String app_name, String app_code, String function_name, String function_code) {
        this.app_name = app_name;
        this.app_code = app_code;
        this.function_name = function_name;
        this.function_code = function_code;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

    public String getFunction_code() {
        return function_code;
    }

    public void setFunction_code(String function_code) {
        this.function_code = function_code;
    }
}