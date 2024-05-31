package com.easwaran2506.irctc.model;

import java.util.List;

public class Tickets {
    private String pnrNumber;
    private String date;
    private String trainNumber;
    private long ticketFare;
    private List<TicketsStatus> ticket;

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public long getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(long ticketFare) {
        this.ticketFare = ticketFare;
    }

    public List<TicketsStatus> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketsStatus> ticket) {
        this.ticket = ticket;
    }

}
