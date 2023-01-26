package dev.danvega.model.Menu;

import java.util.List;

public class FunctionMenu extends SubFunctionMenu{

    private List<SubFunctionMenu> sub_functions;

    public FunctionMenu(String function_code, String function_name, List<SubFunctionMenu> sub_functions) {
        super(function_code, function_name);
        this.sub_functions = sub_functions;


    }

    public List<SubFunctionMenu> getSub_functions() {
        return sub_functions;
    }

    public void setSub_functions(List<SubFunctionMenu> sub_functions) {
        this.sub_functions = sub_functions;
    }
}