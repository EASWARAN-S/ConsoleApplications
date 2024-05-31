package com.easwaran2506.irctc.manageTrains;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.irctc.dataLayer.TicketDatabase;
import com.easwaran2506.irctc.model.Train;
import com.easwaran2506.irctc.model.TrainRoutes;
import com.easwaran2506.irctc.model.User;

public class ManageTrainsModel {
    private ManageTrainsView manageTrainsView;

    public ManageTrainsModel(ManageTrainsView manageTrainsView) {
        this.manageTrainsView = manageTrainsView;

    }

    List<Train> trainsList = new ArrayList<>();
    List<TrainRoutes> trainRoutesList = new ArrayList<>();

    public List<TrainRoutes> getTrainsRoute() {
        trainRoutesList = TicketDatabase.getInstance().readTrainRoutes();
        return trainRoutesList;
    }

    public List<Train> getTrains() {
        trainsList = TicketDatabase.getInstance().readTrains();
        return trainsList;
    }

    public boolean isTrainExists(String trainNumber) {
        trainsList = getTrains();
        boolean isTrainExist = false;
        if (TicketDatabase.getInstance().readTrains() == null) {
            return false;
        }
        for (int i = 0; i < trainsList.size(); i++) {
            if (trainsList.get(i).getTrainNumber().equals(trainNumber))
                isTrainExist = true;
        }

        return isTrainExist;

    }

    public boolean addTrainDetails(String trainNumber, String trainName, String arrivalTime, String departureTime,
            int totalSeats, int fare, String arrivalStation, String departureStation) {
        trainsList = getTrains();
        Train train = new Train();
        train.setFare(fare);
        train.setTotalSeats(totalSeats);
        train.setTrainArrival(arrivalTime);
        train.setTrainDeparture(departureTime);
        train.setTrainName(trainName);
        train.setTrainNumber(trainNumber);
        trainsList.add(train);
        if (TicketDatabase.getInstance().writeTrains(trainsList)) {
            TrainRoutes trainRoute = new TrainRoutes();
            trainRoute.setFromStation(departureStation);
            trainRoute.setToStation(arrivalStation);
            trainRoute.setTrainNumber(trainNumber);
            List<String> route = new ArrayList<>();
            trainRoute.setRoutes(route);
            trainRoutesList.add(trainRoute);
            return TicketDatabase.getInstance().writeTrainRoute(trainRoutesList);
        } else {
            return false;
        }
    }

    public TrainRoutes getTrainsRouteByTrainNumber(String trainNumber) {
        List<TrainRoutes> routeList = getTrainsRoute();
        TrainRoutes trainRoute = new TrainRoutes();
        for (int i = 0; i < routeList.size(); i++) {
            if (routeList.get(i).getTrainNumber().equals(trainNumber)) {
                return routeList.get(i);
            }

        }
        return trainRoute;
    }

    public boolean addTrainRoutes(String trainNumber, TrainRoutes route) {
        List<TrainRoutes> routeList = getTrainsRoute();

        for (int i = 0; i < routeList.size(); i++) {
            if (routeList.get(i).getTrainNumber().equals(trainNumber)) {
                routeList.remove(i);

                break;
            }

        }
        routeList.add(route);
        return TicketDatabase.getInstance().writeTrainRoute(routeList);
    }

    public Train getTrainByTrainNumber(String trainNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTrainByTrainNumber'");
    }

}