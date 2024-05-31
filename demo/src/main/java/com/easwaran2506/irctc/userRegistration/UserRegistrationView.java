package com.easwaran2506.irctc.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.irctc.dataLayer.TicketDatabase;
import com.easwaran2506.irctc.login.LoginView;

import com.easwaran2506.irctc.welcomeScreen.WelcomeScreenView;

public class UserRegistrationView {
    Scanner sc = new Scanner(System.in);
    private UserRegistrationModel userRegistrationModel;

    public UserRegistrationView() {
        userRegistrationModel = new UserRegistrationModel(this);
    }

    public void init() {

        System.out.println("Welcome to Indian Railways  - IRCTC");
        for (int i = 0; i < 75; i++)
            System.out.print("-");
        System.out.println();
        mainMenu();

    }

    private void mainMenu() {
        System.out.println("\n Please Choose the relavent option");
        for (int i = 0; i < 50; i++)
            System.out.print("-");
        System.out.println();
        System.out.println("\n 1.Sign Up \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 0:
                TicketDatabase.getInstance().loginInterface.showAlert("Thank for you using IRCTC...");
                break;
            case 1:

                userRegistrationFrom();
                break;

            default:
                TicketDatabase.getInstance().loginInterface
                        .showAlert("Invalid menu choice ... please enter a valid one");
                init();
                break;

        }
    }

    private void userRegistrationFrom() {
        System.out.println("Enter your Name");
        String userName = sc.nextLine();
        System.out.println("Enter your MobileNumber");
        String userMobile = sc.nextLine();
        if (userMobile.length() > 10) {
            TicketDatabase.getInstance().loginInterface.showAlert("Mobile Number is invalid");
            userRegistrationFrom();
        }
        if (!userRegistrationModel.isMobileNumberExists(userMobile)) {
            System.out.println("Enter your password");
            String password = sc.nextLine();
            userRegistrationModel.addUser(userMobile, password, userName);
        } else {
            TicketDatabase.getInstance().loginInterface
                    .showAlert("Mobile Number is already exists . Please use another mobile number");
            userRegistrationFrom();
        }

    }
}
