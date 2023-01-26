package dev.danvega.model.Menu;

public class SubFunctionMenu {
    private String function_code;
    private String function_name;

    public SubFunctionMenu(String function_code, String function_name) {
        this.function_code = function_code;
        this.function_name = function_name;
    }

    public String getFunction_code() {
        return function_code;
    }

    public void setFunction_code(String function_code) {
        this.function_code = function_code;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }

}

