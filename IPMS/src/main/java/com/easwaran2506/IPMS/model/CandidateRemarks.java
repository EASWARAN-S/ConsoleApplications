package com.easwaran2506.IPMS.model;

public class CandidateRemarks {
    private int remarksSid;
    private int interviewId;
    private int candidateId;
    private int interviewerId;
    private String remarks;
    private int scores;

    public int getRemarksSid() {
        return this.remarksSid;
    }

    public void setRemarksSid(int remarksSid) {
        this.remarksSid = remarksSid;
    }

    public int getInterviewId() {
        return this.interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public int getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getInterviewerId() {
        return this.interviewerId;
    }

    public void setInterviewerId(int interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getScores() {
        return this.scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

}
