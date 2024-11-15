package com.example.owner;

public class UserResponse {
    private String status;
    private String message;
    private String token;
    private String userType;

    // 添加对应的 getter 和 setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getUserType() { // 添加 getUserType 方法
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
