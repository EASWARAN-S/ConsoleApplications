package com.easwaran2506.irctc;

import com.easwaran2506.irctc.welcomeScreen.WelcomeScreenView;

public class TrainTicketManagementSystem {

    private static TrainTicketManagementSystem trainTicketManagement;

    private String appName = "Train Ticket Management System ";

    private String appVersion = "0.1.0";

    private TrainTicketManagementSystem() {

    }

    public static TrainTicketManagementSystem getInstance() {
        if (trainTicketManagement == null) {
            trainTicketManagement = new TrainTicketManagementSystem();
        }
        return trainTicketManagement;
    }

    private void create() {
        WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
        welcomeScreenView.init();
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] args) {
        TrainTicketManagementSystem.getInstance().create();
    }
}
