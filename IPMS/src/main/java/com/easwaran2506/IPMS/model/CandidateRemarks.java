package com.easwaran2506.IPMS.model;

public class CandidateRemarks {
    private int remarksSid;
    private int interviewLogId;
    private int interviewerId;
    private String remarks;
    private int scores;

    public int getRemarksSid() {
        return this.remarksSid;
    }

    public void setRemarksSid(int remarksSid) {
        this.remarksSid = remarksSid;
    }

    public int getInterviewLogId() {
        return this.interviewLogId;
    }

    public void setInterviewLogId(int interviewLogId) {
        this.interviewLogId = interviewLogId;
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

    public int readCandidateRemarks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readCandidateRemarks'");
    }

}
