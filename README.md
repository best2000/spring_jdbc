 List<AppFunction> appFunctions = null;
        //example => {app_name: CCWP, app_code: CCWP, function_code: 10101, function_name: "User Management - Add"}

        List<AppMenu> appMenus = new ArrayList<AppMenu>();
        String app_code;
        String app_name;
        String function_code;
        String function_name;
        AppMenu lastAppMenu = null;
        FunctionMenu lastFunctionMenu = null;

        for (AppFunction appFunction : appFunctions) {
            //update current loop vars
            app_code = appFunction.getApp_code();
            app_name = appFunction.getApp_name();
            function_code = appFunction.getFunction_code();
            function_name = appFunction.getFunction_name();

            //if last appMenus element not the same as current appMenu
            if (appMenus.isEmpty()
                    || appMenus.get(appMenus.size() - 1).getApp_code() != app_code) {
                //add new 'AppMenu' to 'appMenus' list
                appMenus.add(new AppMenu(app_code, app_name, new ArrayList<FunctionMenu>()));
                //update var
                lastAppMenu = appMenus.get(appMenus.size() - 1);
            }

            //if function_code is 'FunctionMenu' of last 'AppMenu' in 'appMenus' list
            if ((function_code.substring(function_code.length() - 2) == "00")
                    && (app_code == lastAppMenu.getApp_code())) {
                //add new 'FunctionMenu' to last 'AppMenu'
                lastAppMenu.getFunctions().add(new FunctionMenu(function_code, function_name, new ArrayList<SubFunctionMenu>()));
                //update var
                lastFunctionMenu = lastAppMenu.getFunctions().get(lastAppMenu.getFunctions().size() - 1);
            }
            //else if function_code is 'SubFunctionMenu' of last 'FunctionMenu'
            else if ((function_code.substring(0,3) == lastFunctionMenu.getFunction_code().substring(0,3))
                    && (app_code == lastAppMenu.getApp_code())){
                //add new 'SubFunctionMenu' to last 'FunctionMenu'
                lastFunctionMenu.getSub_functions().add(new SubFunctionMenu(function_code, function_name));
            }

        }




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
