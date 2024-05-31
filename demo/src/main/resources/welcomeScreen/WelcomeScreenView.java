package com.easwaran2506.ticketSystem.welcomeScreen;

import java.util.Scanner;

import com.easwaran2506.ticketSystem.TicketDesk;
import com.easwaran2506.ticketSystem.login.LoginView;

public class WelcomeScreenView {
    private WelcomeScreenModel welcomeScreenModel;
    Scanner sc = new Scanner(System.in);

    public WelcomeScreenView() {
        this.welcomeScreenModel = new WelcomeScreenModel();
    }

    public void init() {
        System.out.println(" ------- " + TicketDesk.getInstance().getAppName() + " ------ \nversion " +
                TicketDesk.getInstance().getAppVersion());
        System.out.println("Welcome to Ticketing System - Help Desk ");
        System.out.println("\n 1. Login \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        // LoginView loginView = new LoginView();
        switch (choice) {
            case 0:
                showAlert("Thank for you using Ticketing System...");
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