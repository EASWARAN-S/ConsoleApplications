package com.easwaran2506.model;

import java.util.List;

public class Tickets {
    private String pnrNumber;
    private String date;
    private String trainNumber;
    private long ticketFare;

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public long getTicketFare() {
        return this.ticketFare;
    }

    public void setTicketFare(long ticketFare) {
        this.ticketFare = ticketFare;
    }

}
