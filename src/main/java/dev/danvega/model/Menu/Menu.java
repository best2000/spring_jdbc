package dev.danvega.model.Menu;

public class Menu{
        private String app_name ;
        private Integer app_id ;
        private String function_name ;
        private Integer function_id ;

    public Menu(String app_name, Integer app_id, String function_name, Integer function_id) {
        this.app_name = app_name;
        this.app_id = app_id;
        this.function_name = function_name;
        this.function_id = function_id;
    }

    public String getApp_name() {
            return app_name;
        }

        public Integer getApp_id() {
            return app_id;
        }

        public String getFunction_name() {
            return function_name;
        }

        public Integer getFunction_id() {
            return function_id;
        }

    @Override
    public String toString() {
        return "Menu{" +
                "app_name='" + app_name + '\'' +
                ", app_id=" + app_id +
                ", function_name='" + function_name + '\'' +
                ", function_id=" + function_id +
                '}';
    }




}
