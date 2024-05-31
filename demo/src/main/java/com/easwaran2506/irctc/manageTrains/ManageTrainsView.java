package com.easwaran2506.irctc.manageTrains;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.irctc.TrainTicketManagementSystem;
import com.easwaran2506.irctc.dataLayer.TicketDatabase;
import com.easwaran2506.irctc.model.Train;
import com.easwaran2506.irctc.model.TrainRoutes;

public class ManageTrainsView {
    private ManageTrainsModel manageTrainsModel;
    Scanner sc = new Scanner(System.in);
    int userId;

    public ManageTrainsView() {
        this.manageTrainsModel = new ManageTrainsModel(this);
    }

    public void init(int userId) {
        this.userId = userId;
        System.out.println(" ------- " + TrainTicketManagementSystem.getInstance().getAppName() + " ------ \nversion " +
                TrainTicketManagementSystem.getInstance().getAppVersion());
        System.out.println("Welcome to Indian Railways  - IRCTC ");
        System.out.println(
                "\n 1. Add Trains \n 2.Add Routes \n 3 Display Trains and its Routes \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 0:
                TicketDatabase.getInstance().loginInterface.showAlert("Thank for you using IRCTC ...");
                break;
            case 1:
                AddTrains();
                break;
            case 2:
                AddTrainsRoutes();
                break;
            case 3:
                DisplayTrainsAndItsRoute();
                break;

            default:
                TicketDatabase.getInstance().loginInterface
                        .showAlert("Invalid menu choice ... please enter a valid one");
                init(userId);
                break;

        }
    }

    public void DisplayTrainsAndItsRoute() {
        System.out.println("Train Details and Its Routes");
        System.out.println("Enter the Train Number");
        String trainNumber = sc.nextLine();
        if (!manageTrainsModel.isTrainExists(trainNumber)) {
            TicketDatabase.getInstance().loginInterface
                    .showAlert("Train Number not  Exists Please give valid Train...");
            DisplayTrainsAndItsRoute();
        } else {
            Train train = new Train();
            TrainRoutes route = new TrainRoutes();
            train = manageTrainsModel.getTrainByTrainNumber(trainNumber);
            route = manageTrainsModel.getTrainsRouteByTrainNumber(trainNumber);
            System.out.println("Train Name: " + train.getTrainName());
            System.out.println("Train departure Time: " + train.getTrainDeparture());
            System.out.println("Train arrival Time: " + train.getTrainArrival());
            System.out.println("Train Total Seats: " + train.getTotalSeats());
            System.out.println("Train Fare: " + train.getFare());
            System.out.println("Train From Station: " + route.getFromStation());
            System.out.println("Train To Station: " + route.getToStation());
            System.out.println("Train Routes are");
            for (int i = 0; i < route.getRoutes().size(); i++) {
                System.out.println(route.getRoutes().get(i));
            }
        }
    }

    public void AddTrainsRoutes() {
        System.out.println("Enter the Train Number");
        String trainNumber = sc.nextLine();
        if (!manageTrainsModel.isTrainExists(trainNumber)) {
            TicketDatabase.getInstance().loginInterface
                    .showAlert("Train Number not  Exists Please add the train and then the Route..");
            init(userId);
        } else {
            TrainRoutes route = new TrainRoutes();
            route = manageTrainsModel.getTrainsRouteByTrainNumber(trainNumber);
            System.out.println("How many routes you want to enter");
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Routes Between the " + route.getFromStation() + " station and "
                    + route.getToStation() + "  station \n Enter one by one");
            List<String> routes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                routes.add(sc.nextLine());
            }
            route.setRoutes(routes);
            if (manageTrainsModel.addTrainRoutes(trainNumber, route)) {
                init(userId);
            } else {
                TicketDatabase.getInstance().loginInterface.showAlert("Train Routes Not added Please Try again");
                AddTrainsRoutes();
            }

        }
    }

    public void AddTrains() {
        System.out.println("Enter the Train Number");
        String trainNumber = sc.nextLine();
        if (manageTrainsModel.isTrainExists(trainNumber)) {
            TicketDatabase.getInstance().loginInterface
                    .showAlert("Train Number Already Exists Please give new Number to add");
        } else {
            System.out.println("Enter the Train Name");
            String trainName = sc.nextLine();
            System.out.println("Enter the Train Arrival Time in 24 hrs Format For say \" 04:00 \" ");
            String arrivalTime = sc.nextLine();
            System.out.println("Enter the Train Departure Time in 24 hrs Format For say \" 14:00 \" ");
            String departureTime = sc.nextLine();
            System.out.println("Enter the Total Number of Seats ");
            int totalSeats = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the  fare for per passenger ");
            int fare = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the Departure  Station ");
            String departureStation = sc.nextLine();
            System.out.println("Enter the Arrival Station");
            String arrivalStation = sc.nextLine();
            if (manageTrainsModel.addTrainDetails(trainNumber, trainName, arrivalTime, departureTime, totalSeats,
                    fare, arrivalStation, departureStation)) {
                AddTrainsRoutes();
            } else {
                TicketDatabase.getInstance().loginInterface.showAlert("Error in adding the Train Please Retry..");
                AddTrainsRoutes();
            }
        }

    }

}
