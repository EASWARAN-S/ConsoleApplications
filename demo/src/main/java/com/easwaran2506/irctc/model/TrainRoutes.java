package com.easwaran2506.irctc.model;

import java.util.List;

public class TrainRoutes
 {
    private String trainNumber;
    private String fromStation;
    private String toStation;
    private List<String> routes;


    public String getTrainNumber() {
        return this.trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return this.toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public List<String> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

}