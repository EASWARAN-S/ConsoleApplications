package com.easwaran2506.IPMS.model;

public class User {
    private int userId;
    private String userName;
    private String userAddress;
    private String userEmail;
    private long userMobile;
    private String userDesignation;
    private String userDoj;
    private int userCompanyId;
    private int userType; /* 1 - Admin 2- interviewer 3- receptionist 4 - candidate */

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserMobile() {
        return this.userMobile;
    }

    public void setUserMobile(long userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserDesignation() {
        return this.userDesignation;
    }

    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }

    public String getUserDoj() {
        return this.userDoj;
    }

    public void setUserDoj(String userDoj) {
        this.userDoj = userDoj;
    }

    public int getUserCompanyId() {
        return this.userCompanyId;
    }

    public void setUserCompanyId(int userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

}
