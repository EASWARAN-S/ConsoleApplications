package com.easwaran2506.irctc.welcomeScreen;

import java.util.Scanner;

import com.easwaran2506.irctc.TrainTicketManagementSystem;
import com.easwaran2506.irctc.login.LoginView;

public class WelcomeScreenView {
    private WelcomeScreenModel welcomeScreenModel;
    Scanner sc = new Scanner(System.in);

    public WelcomeScreenView() {
        this.welcomeScreenModel = new WelcomeScreenModel();
    }

    public void init() {
        System.out.println(" ------- " + TrainTicketManagementSystem.getInstance().getAppName() + " ------ \nversion " +
                TrainTicketManagementSystem.getInstance().getAppVersion());
        System.out.println("Welcome to Indian Railways  - IRCTC ");
        System.out.println("\n 1. Login \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        // LoginView loginView = new LoginView();
        switch (choice) {
            case 0:
                showAlert("Thank for you using IRCTC ...");
                break;
            case 1:
                LoginView loginView = new LoginView();
                loginView.init();

                break;

            default:
                showAlert("Invalid menu choice ... please enter a valid one");
                init();
                break;

        }
    }

    private void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}