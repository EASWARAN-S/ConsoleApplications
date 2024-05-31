package com.easwaran2506.model;

public class TicketStatus {
    private String pnrNumber;
    private Long passengerId;
    private String ticketStatus;

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public Long getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
