package com.easwaran2506.model;

public class Train {
    private String trainNumber;
    private String trainName;
    private int totalSeats;
    private int fare;
    private String departureTime;
    private String arrivalTIme;

    public String getArrivalTIme() {
        return arrivalTIme;
    }

    public void setArrivalTIme(String arrivalTIme) {
        this.arrivalTIme = arrivalTIme;
    }

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

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    private String arrivalTime;

}
