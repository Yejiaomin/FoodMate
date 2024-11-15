package com.example.owner;

public class Restaurant {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String openingTime;

    public Restaurant(String email, String password, String name, String phone, String openingTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.openingTime = openingTime;
    }

    public Restaurant() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }
}
