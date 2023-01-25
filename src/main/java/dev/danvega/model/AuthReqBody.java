package dev.danvega.model;

public class AuthReqBody {
    private String app_code;
    private String function_code;

    public AuthReqBody(String app_code, String function_code) {
        this.app_code = app_code;
        this.function_code = function_code;
    }

    public String getApp_code() {
        return app_code;
    }

    public void setApp_code(String app_code) {
        this.app_code = app_code;
    }

    public String getFunction_code() {
        return function_code;
    }

    public void setFunction_code(String function_code) {
        this.function_code = function_code;
    }

    @Override
    public String toString() {
        return "AuthReqBody{" +
                "app_code='" + app_code + '\'' +
                ", function_code='" + function_code + '\'' +
                '}';
    }
}
