package dev.danvega.model.Menu;

public class AppFunctionMenu {
    private Integer function_id;
    private String function_name;

    public AppFunctionMenu(Integer function_id, String function_name) {
        this.function_id = function_id;
        this.function_name = function_name;
    }

    public Integer getFunction_id() {
        return function_id;
    }

    public void setFunction_id(Integer function_id) {
        this.function_id = function_id;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
    }
}
