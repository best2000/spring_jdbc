package dev.danvega.model;

public class Permission {

    private User user;
    private Integer appFunctionId;

    private String appFunctionName;
    private verificationStatus status = verificationStatus.UNKNOW;

    public enum verificationStatus {
        UNKNOW,
        PASSED,
        FAILED;
    }

    public Permission(User user, Integer appFunctionId, String appFunctionName) {
        this.user = user;
        this.appFunctionId = appFunctionId;
        this.appFunctionName = appFunctionName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAppFunctionId() {
        return appFunctionId;
    }

    public void setAppFunctionId(Integer appFunctionId) {
        this.appFunctionId = appFunctionId;
    }

    public String getAppFunctionName() {
        return appFunctionName;
    }

    public void setAppFunctionName(String appFunctionName) {
        this.appFunctionName = appFunctionName;
    }

    public verificationStatus getStatus() {
        return status;
    }

    public Permission setStatus(verificationStatus status) {
        this.status = status;
        return null;
    }

    @Override
    public String toString() {
        return "UserPermission{" +
                "user=" + user +
                ", appFunctionId=" + appFunctionId +
                ", appFunctionName='" + appFunctionName + '\'' +
                ", status=" + status +
                '}';
    }
}
