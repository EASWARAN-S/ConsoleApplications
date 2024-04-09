package com.easwaran2506.IPMS.model;

public class InterviewLog {
    private int interviewlogid;
    private int interviewid;
    private int candidateid;
    private String currentStatus;

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getInterviewlogid() {
        return this.interviewlogid;
    }

    public void setInterviewlogid(int interviewlogid) {
        this.interviewlogid = interviewlogid;
    }

    public int getInterviewid() {
        return this.interviewid;
    }

    public void setInterviewid(int interviewid) {
        this.interviewid = interviewid;
    }

    public int getCandidateid() {
        return this.candidateid;
    }

    public void setCandidateid(int candidateid) {
        this.candidateid = candidateid;
    }

    public String getCurrentstatus() {
        return this.currentstatus;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    private String currentstatus;

}
