package dev.danvega.model;

public class User {
    private Integer id;
    private String userLogin;

    public User(Integer id, String userLogin) {
        this.id = id;
        this.userLogin = userLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}
