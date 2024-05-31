package com.easwaran2506;

import java.util.*;

import com.easwaran2506.model.Passenger;
import com.easwaran2506.model.TicketStatus;
import com.easwaran2506.model.Tickets;
import com.easwaran2506.model.Train;
import com.easwaran2506.model.TrainRoute;

public class Ticket {
    Scanner sc = new Scanner(System.in);
    List<Train> trainList = new ArrayList<>();
    List<TrainRoute> trainRoutesList = new ArrayList<>();
    List<Tickets> ticketList = new ArrayList<>();
    List<TicketStatus> ticketStatusList = new ArrayList<>();
    List<Passenger> passengerList = new ArrayList<>();

    public static void main(String[] args) {
        Ticket tkt = new Ticket();
        tkt.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to Indian Railway IRCTC...");
        System.out.println(
                "Enter Your Choice.... \n 1 . Add Trains \n 2. Display Trains and Its Routes \n3 Add Train Route \n4 Book Ticket \n5 Get PNR Status \n6 Booked TIckets \n7 Canccelled Tickets \n8 Search Trains \n9 Search PassengerBy Id  ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addTrains();
                break;
            case 2:
                displayTrainsAndItsRoutes();
                break;
            case 3:
                addTrainRoutes();
                break;
            case 4:
                bookTicket();
                break;
            case 5:
                getPNRStatus();
                break;
            case 6:
                getBookedTickets();
                break;
            case 7:
                getBookedTickets();
                break;
            case 8:
                addTrains();
                break;
            case 9:
                searchPassengers();
                break;
            default:
                System.out.println("Invalid Choice Please Retry");
                break;
        }

    }

    private void addTrainRoutes() {
        List<String> route = new ArrayList<>();
        TrainRoute trainRoutes = new TrainRoute();
        System.out.println("Enter  the Train Number");
        String trainNumber = sc.nextLine();
        if (checkTrainNumber(trainNumber)) {
            System.out.println("How many routes you want to add ? ");
            int n = sc.nextInt();
            sc.nextLine();
            trainRoutes = getTrainRoute(trainNumber);
            System.out.println("Enter the route in between the following stations " + trainRoutes.getArrivalStation()
                    + " and  " + trainRoutes.getDepartureStation());
            for (int i = 0; i < n; i++) {
                route.add(sc.nextLine());
            }
            trainRoutes.setRoutes(route);
            trainRoutesList.add(trainRoutes);
        } else {
            System.out.println("Train not added Please add the train");
        }

    }

    private void searchPassengers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPassengers'");
    }

    private void getBookedTickets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookedTickets'");
    }

    private void getPNRStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPNRStatus'");
    }

    private void bookTicket() {
        long passengerId = passengerList.get(passengerList.size() - 1).getPassengerId();
        long passengerOriginalId = passengerId;
        Tickets tkts = new Tickets();
        TicketStatus tktStat = new TicketStatus();
        System.out.println("Enter the From Station");
        String fromStation = sc.nextLine();
        System.out.println("Enter the To station");
        String toStation = sc.nextLine();
        Train train = new Train();
        if (CheckAvailableTrains(fromStation, toStation)) {
            List<String> trainNumber = new ArrayList<>();
            trainNumber = getAvailableTrains(fromStation, toStation);
            for (int i = 0; i < trainNumber.size(); i++) {
                System.out.println("Choose the Train You Want to book");
                System.out.println(i + 1 + ". for Train Number :" + trainNumber.get(i));
                displayTrains(trainNumber.get(i));
            }
            System.out.println("Enter your choice ...");
            int choice = sc.nextInt();
            sc.nextLine();
            tkts.setTrainNumber(trainNumber.get(choice - 1));
            System.out.println("Enter the Date in the DD-MM-YYYY format for say 06-05-2000");
            String date = sc.nextLine();
            if (date.length() > 10) {
                System.out.println("Invalid date  Please retry again");
                bookTicket();
            }
            tkts.setDate(date);
            Passenger passenger = new Passenger();
            System.out.println("How many person needs to be Travelled..");
            int n = sc.nextInt();
            List<Passenger> ls = new ArrayList<>();
            train = getTrain(trainNumber.get(choice - 1));
            for (int k = 0; k < n; k++) {
                Passenger ps = new Passenger();
                System.out.println("Enter the passenger name");
                String passengerName = sc.nextLine();
                ps.setName(passengerName);
                System.out.println("Enter the passenger age");
                int age = sc.nextInt();
                sc.nextLine();
                ps.setAge(age);
                System.out.println("Enter the passenger Gender M- For Male F - For Female O For Others");
                String gender = sc.nextLine();
                ps.setGender(gender);
                ps.setPassengerId(passengerId++);
                ls.add(ps);
                System.out.println("Passenger Added Successfully The Passenger Id is " + passengerId);

            }
            System.out.println("Total Fare is " + (train.getFare() * n));
            System.out.println("Do yow want to pay Please enter  1 to pay and 0 to cancel");
            int option = sc.nextInt();
            String pnrNumber;
            if (option == 1) {
                for (int k = 0; k < ls.size(); k++) {
                    passengerList.add(ls.get(k));
                }
                if (ticketStatusList.size() == 0) {
                    pnrNumber = "TKT" + "1";
                } else {
                    pnrNumber = "TKT" + (Integer.parseInt(
                            ticketStatusList.get(ticketStatusList.size() - 1).getPnrNumber().substring(3)) + 1);
                    tktStat.setPnrNumber(pnrNumber);
                    tktStat.setTicketStatus("WL");
                    for (int l = 0; l < ls.size(); l++) {
                        tktStat.setPassengerId(ls.get(l).getPassengerId());
                        ticketStatusList.add(tktStat);
                    }
                }

            } else {
                passengerId = passengerOriginalId;
                mainMenu();

            }

        }
    }

    private boolean CheckAvailableTrains(String fromStation, String toStation) {
        // List<String> TrainNumber =
        for (int i = 0; i < trainRoutesList.size(); i++) {
            if (trainRoutesList.get(i).getArrivalStation().equals(toStation)) {
                if (trainRoutesList.get(i).getDepartureStation().equals(fromStation)) {
                    return true;
                } else {
                    for (int j = 0; j < trainRoutesList.get(i).getRoutes().size(); j++) {
                        if (trainRoutesList.get(i).getRoutes().get(j).equals(fromStation)) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    private List<String> getAvailableTrains(String fromStation, String toStation) {
        List<String> trainNumber = new ArrayList<>();
        for (int i = 0; i < trainRoutesList.size(); i++) {
            if (trainRoutesList.get(i).getArrivalStation().equals(toStation)) {
                if (trainRoutesList.get(i).getDepartureStation().equals(fromStation)) {
                    trainNumber.add(trainRoutesList.get(i).getTrainNumber());
                } else {
                    for (int j = 0; j < trainRoutesList.get(i).getRoutes().size(); j++) {
                        if (trainRoutesList.get(i).getRoutes().get(j).equals(fromStation)) {
                            trainNumber.add(trainRoutesList.get(i).getTrainNumber());
                        }
                    }
                }
            }

        }
        return trainNumber;
    }

    private void displayTrains(String trainNumber) {
        TrainRoute routes = getTrainRoute(trainNumber);
        Train train = getTrain(trainNumber);
        System.out.println("Train name : " + train.getTrainName());
        System.out.println("Train Number : " + train.getTrainNumber());
        System.out.println("Total Number of seats : " + train.getTotalSeats());
        System.out.println("Train Fare : " + train.getFare());
        System.out.println("Train Arrival Time : " + train.getArrivalTIme());
        System.out.println("Train Departure Time : " + train.getDepartureTime());
        System.out.println("Train Arrival Station : " + routes.getArrivalStation());
        System.out.println("Train Departure Station : " + routes.getDepartureStation());
    }

    private void displayTrainsAndItsRoutes() {
        TrainRoute routes = new TrainRoute();
        Train train = new Train();
        System.out.println("Display the Train Details...");
        System.out.println("Enter  the Train Number");
        String trainNumber = sc.nextLine();
        if (checkTrainNumber(trainNumber)) {
            routes = getTrainRoute(trainNumber);
            train = getTrain(trainNumber);
            System.out.println("Train name : " + train.getTrainName());
            System.out.println("Train Number : " + train.getTrainNumber());
            System.out.println("Total Number of seats : " + train.getTotalSeats());
            System.out.println("Train Fare : " + train.getFare());
            System.out.println("Train Arrival Time : " + train.getArrivalTIme());
            System.out.println("Train Departure Time : " + train.getDepartureTime());
            System.out.println("Train Arrival Station : " + routes.getArrivalStation());
            System.out.println("Train Departure Station : " + routes.getDepartureStation());
            System.out.println("Train Travel in routes are  ");
            for (int i = 0; i < routes.getRoutes().size(); i++) {
                System.out.print(routes.getRoutes().get(i) + " \t");
            }

        } else {
            System.out.println("");
        }
    }

    private void addTrains() {

        Train train = new Train();
        TrainRoute route = new TrainRoute();
        System.out.println("Enter the Train Number");
        String trainNumber = sc.nextLine();
        sc.nextLine();
        if (!checkTrainNumber(trainNumber)) {
            train.setTrainNumber(trainNumber);
            System.out.println("Enter the Train Name");
            String trainName = sc.nextLine();
            train.setTrainName(trainName);
            System.out.println("Enter the Departure time");
            String departureTime = sc.nextLine();
            train.setDepartureTime(departureTime);
            System.out.println("Enter the Arrival Time");
            String arrivalTIme = sc.nextLine();
            train.setArrivalTIme(arrivalTIme);
            System.out.println("Enter the total Seats");
            int totalSeats = sc.nextInt();
            train.setTotalSeats(totalSeats);
            sc.nextLine();
            System.out.println("Enter the Ticket Fare");
            int fare = sc.nextInt();
            train.setFare(fare);
            sc.nextLine();
            System.out.println("Enter the Arrival Station");
            String arrivalStation = sc.nextLine();
            route.setArrivalStation(arrivalStation);
            System.out.println("Enter the Departure  Station");
            String departureStation = sc.nextLine();
            route.setDepartureStation(departureStation);
            route.setTrainNumber(trainNumber);
            List<String> str = new ArrayList<>();
            route.setRoutes(str);
            trainList.add(train);
            trainRoutesList.add(route);
            System.out.println("Train Added Successfully Kindly add train Routes");
            mainMenu();
        } else {
            addTrains();
        }

    }

    private boolean checkTrainNumber(String trainNumber) {

        for (int i = 0; i < trainList.size(); i++) {
            if (trainList.get(i).getTrainNumber().equals(trainNumber))
                return true;
        }
        return false;
    }

    private TrainRoute getTrainRoute(String trainNumber) {

        for (int i = 0; i < trainRoutesList.size(); i++) {
            if (trainRoutesList.get(i).getTrainNumber().equals(trainNumber))
                return trainRoutesList.get(i);
        }
        return null;
    }

    private Train getTrain(String trainNumber) {

        for (int i = 0; i < trainList.size(); i++) {
            if (trainList.get(i).getTrainNumber().equals(trainNumber))
                return trainList.get(i);
        }
        return null;
    }
}