package com.easwaran2506.irctc.dataLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.irctc.home.HomeScreenView;
import com.easwaran2506.irctc.home.homeScreenModel;
import com.easwaran2506.irctc.interfaces.LoginInterface;
import com.easwaran2506.irctc.login.LoginModel;
import com.easwaran2506.irctc.manageTrains.ManageTrainsView;
import com.easwaran2506.irctc.model.Train;
import com.easwaran2506.irctc.model.TrainRoutes;
import com.easwaran2506.irctc.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TicketDatabase {

    private static TicketDatabase ticketDatabase;

    public LoginInterface loginInterface;
    public ManageTrainsView manageTrainsView = new ManageTrainsView();
    public HomeScreenView homeScreenView = new HomeScreenView();
    public LoginModel loginModel = new LoginModel(loginInterface);

    String filePathUser = "user.json";
    String fileTrain = "trains.json";
    String fileTrainRoute = "trainRoute.json";
    int userType;
    int userId;

    List<User> userList = new ArrayList<>();
    List<Train> trainsList = new ArrayList<>();
    List<TrainRoutes> trainRouteList = new ArrayList<>();

    public void init() {
        userList = TicketDatabase.getInstance().readUser();

    }

    public static TicketDatabase getInstance() {
        if (ticketDatabase == null) {
            ticketDatabase = new TicketDatabase();
        }
        return ticketDatabase;

    }

    public boolean isValidUser(String userMobile, String Password) {
        boolean isValidUser = false;
        for (int i = 0; i < readUser().size(); i++) {
            if ((userList.get(i).getMobile().equals(userMobile))
                    && (userList.get(i).getPassword().equals(Password))) {
                isValidUser = true;
                break;
            }
        }
        return isValidUser;
    }

    public List<User> readUser() {
        try {
            File file = new File(filePathUser);
            if (!file.exists()) {
                file.createNewFile();
            }
            List<User> userList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(new File(filePathUser), new TypeReference<List<User>>() {
            });
            return userList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> readTrains() {
        try {
            File file = new File(fileTrain);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            trainsList = mapper.readValue(new File(fileTrain), new TypeReference<List<Train>>() {
            });
            return trainsList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeUser(List<User> user) {
        try {
            File file = new File(filePathUser);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, user);
            return true;
        } catch (Exception e) {
            loginInterface.showAlert("Error Occured while adding user");
            return false;
        }
    }

    public boolean writeTrains(List<Train> train) {
        try {
            File file = new File(fileTrain);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, train);
            return true;
        } catch (Exception e) {
            loginInterface.showAlert("Error Occured while adding Train");
            return false;
        }
    }

    public List<TrainRoutes> readTrainRoutes() {
        try {
            File file = new File(fileTrain);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            trainRouteList = mapper.readValue(new File(fileTrainRoute), new TypeReference<List<TrainRoutes>>() {
            });
            return trainRouteList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeTrainRoute(List<TrainRoutes> trainRoutesList) {
        try {
            File file = new File(fileTrainRoute);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, trainRoutesList);
            return true;
        } catch (Exception e) {
            loginInterface.showAlert("Error Occured while adding Train");
            return false;
        }
    }

    public void redirectToHome(String userMobile) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getMobile().equals(userMobile)) {
                userType = userList.get(i).getUserType();
                userId = userList.get(i).getUserId();
            }
        }
        if (userType == 2) {
            manageTrainsView.init(userId);
        } else {
            homeScreenView.init(userId);
        }

    }

}