package dev.danvega.model.Menu;

public class UserSession {
    private String userLogin;

    public UserSession(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
