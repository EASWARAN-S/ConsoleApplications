package com.easwaran2506.model;

public class Library {
    private int libraryId;
    private String libraryName;
    private String libraryAddress;
    private String libraryInchargeName;
    private String phoneNo;
    private String emailId;
    private int libraryActiveStatus;

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryInchargeName(String libraryInchargeName) {
        this.libraryInchargeName = libraryInchargeName;
    }

    public String getLibraryInchargeName() {
        return libraryInchargeName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setLibraryActiveStatus(int libraryActiveStatus) {
        this.libraryActiveStatus = libraryActiveStatus;
    }

    public int getLibraryActiveStatus() {
        return libraryActiveStatus;
    }

}
