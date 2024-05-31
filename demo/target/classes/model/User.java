package com.easwaran2506.ticketSystem.model;

public class User {
    private int userId;
    private String name;
    private int userType;
    private String userAddress;
    private String email;
    private long mobile;
    private int userActiveStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getUserActiveStatus() {
        return userActiveStatus;
    }

    public void setUserActiveStatus(int userActiveStatus) {
        this.userActiveStatus = userActiveStatus;
    }

}
