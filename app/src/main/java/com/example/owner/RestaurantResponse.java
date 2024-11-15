package com.example.owner;

public class RestaurantResponse {
    private String message; // 对应后端返回的 "message" 字段
    private String error;   // 如果有错误，对应后端返回的 "error" 字段
    private String userType;

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUserType() {
        return "";
    }
}
