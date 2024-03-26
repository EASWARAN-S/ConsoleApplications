package com.easwaran2506.IPMS.model;

public class Interview {
    private int interviewId;
    private String interviewDate;
    private String interviewtime;
    private int companyId;
    private String interviewRole;
    private int individualScoreLimit;
    private int noOfInterviewers;

    public int getInterviewId() {
        return this.interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewDate() {
        return this.interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewtime() {
        return this.interviewtime;
    }

    public void setInterviewtime(String interviewtime) {
        this.interviewtime = interviewtime;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getInterviewRole() {
        return this.interviewRole;
    }

    public void setInterviewRole(String interviewRole) {
        this.interviewRole = interviewRole;
    }

    public int getIndividualScoreLimit() {
        return this.individualScoreLimit;
    }

    public void setIndividualScoreLimit(int individualScoreLimit) {
        this.individualScoreLimit = individualScoreLimit;
    }

    public int getNoOfInterviewers() {
        return this.noOfInterviewers;
    }

    public void setNoOfInterviewers(int noOfInterviewers) {
        this.noOfInterviewers = noOfInterviewers;
    }

}
