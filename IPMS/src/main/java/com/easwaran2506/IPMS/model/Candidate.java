package com.easwaran2506.IPMS.model;

public class Candidate {
    private int candidateId;
    private String candidateName;
    private String candidateAddress;
    private int candidateAge;
    private String candidateFatherName;
    private String candidateDob;
    private String candidateSkills;
    private long candidateContact;
    private String candidateEmail;
    private boolean isExperienced;
    private int yearOfExeperience;
    private boolean isAppointed;
    private String appointedOn;

    public String getCandidateAddress() {
        return candidateAddress;
    }

    public void setCandidateAddress(String candidateAddress) {
        this.candidateAddress = candidateAddress;
    }

    public int getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getCandidateAge() {
        return this.candidateAge;
    }

    public void setCandidateAge(int candidateAge) {
        this.candidateAge = candidateAge;
    }

    public String getCandidateFatherName() {
        return this.candidateFatherName;
    }

    public void setCandidateFatherName(String candidateFatherName) {
        this.candidateFatherName = candidateFatherName;
    }

    public String getCandidateDob() {
        return this.candidateDob;
    }

    public void setCandidateDob(String candidateDob) {
        this.candidateDob = candidateDob;
    }

    public String getCandidateSkills() {
        return this.candidateSkills;
    }

    public void setCandidateSkills(String candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    public long getCandidateContact() {
        return this.candidateContact;
    }

    public void setCandidateContact(long candidateContact) {
        this.candidateContact = candidateContact;
    }

    public String getCandidateEmail() {
        return this.candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public boolean isIsExperienced() {
        return this.isExperienced;
    }

    public boolean getIsExperienced() {
        return this.isExperienced;
    }

    public void setIsExperienced(boolean isExperienced) {
        this.isExperienced = isExperienced;
    }

    public int getYearOfExeperience() {
        return this.yearOfExeperience;
    }

    public void setYearOfExeperience(int yearOfExeperience) {
        this.yearOfExeperience = yearOfExeperience;
    }

    public boolean isIsAppointed() {
        return this.isAppointed;
    }

    public boolean getIsAppointed() {
        return this.isAppointed;
    }

    public void setIsAppointed(boolean isAppointed) {
        this.isAppointed = isAppointed;
    }

    public String getAppointedOn() {
        return this.appointedOn;
    }

    public void setAppointedOn(String appointedOn) {
        this.appointedOn = appointedOn;
    }

}
