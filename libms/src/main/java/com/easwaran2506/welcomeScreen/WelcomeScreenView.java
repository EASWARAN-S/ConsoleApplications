package com.easwaran2506.welcomeScreen;

import java.util.Scanner;

import com.easwaran2506.LibraryManagement;
import com.easwaran2506.login.LoginView;
import com.easwaran2506.userRegistration.UserRegistrationView;

public class WelcomeScreenView {
    private WelcomeScreenModel welcomeScreenModel;
    Scanner sc = new Scanner(System.in);

    public WelcomeScreenView() {
        welcomeScreenModel = new WelcomeScreenModel(this);
    }

    public void init() {
        System.out.println(" ------- " + LibraryManagement.getInstance().getAppName() + " ------ \nversion " +
                LibraryManagement.getInstance().getAppVersion());
        System.out.println("Welcome to Library  Management System - LIBMS");
        System.out.println("\n 1. Login \n 2. signUp  \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        // LoginView loginView = new LoginView();
        switch (choice) {
            case 0:
                showAlert("Thank for you using LIBMS...");
                break;
            case 1:
                LoginView loginView = new LoginView();
                loginView.init();

                break;
            case 2:
                UserRegistrationView userRegistrationView = new UserRegistrationView();
                userRegistrationView.init();
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