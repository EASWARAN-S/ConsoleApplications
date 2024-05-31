package com.easwaran2506.irctc.model;

public class Train {
    private String trainNumber;
    private String trainName;
    private String trainDeparture;
    private String trainArrival;
    private int totalSeats;
    private int fare;

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainDeparture() {
        return this.trainDeparture;
    }

    public void setTrainDeparture(String trainDeparture) {
        this.trainDeparture = trainDeparture;
    }

    public String getTrainArrival() {
        return this.trainArrival;
    }

    public void setTrainArrival(String trainArrival) {
        this.trainArrival = trainArrival;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getFare() {
        return this.fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

}
