package com.easwaran2506.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.model.Library;
import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class UserRegistrationView {
    Scanner sc = new Scanner(System.in);
    private UserRegistrationModel userRegistrationModel;

    public UserRegistrationView() {
        userRegistrationModel = new UserRegistrationModel(this);
    }

    public void init() {

        System.out.println("Welcome to Library  Management System - LIBMS");
        for (int i = 0; i < 75; i++)
            System.out.print("-");
        System.out.println();
        userRegistrationForm();

    }

    private void userRegistrationForm() {
        System.out.println("Enter your Name");
        String userName = sc.nextLine();
        System.out.println("Enter your Address");
        String userAddress = sc.nextLine();

        System.out.println("Enter your EmailId ");
        String userEmail = sc.nextLine();
        if (!userRegistrationModel.isValidEmail(userEmail)) {
            System.out.println("Email id is  wrong Please Reenter it");
            userRegistrationForm();
        }
        if (!userRegistrationModel.isEmailAlreadyExists(userEmail)) {
            System.out.println("Email id is already exists  Please try with unique mail Id");
            userRegistrationForm();
        }
        System.out.println("Enter your MobileNumber");
        long userMobile = sc.nextLong();
        sc.nextLine();
        List<Library> libraryList = userRegistrationModel.readLibrary();
        System.out.println("Choose  the library");
        String[] libraryName = new String[libraryList.size()];
        for (int i = 0; i < libraryList.size(); i++) {
            libraryName[i] = libraryList.get(i).getLibraryName();

        }
        for (int j = 0; j < libraryName.length; j++) {
            System.out.println((j + 1) + " . " + libraryName[j]);
        }
        System.out.println("Type your choice ");
        int libraryId = sc.nextInt();
        sc.nextLine();

        if (userRegistrationModel.addUser(userName, userAddress,
                userMobile, userEmail, libraryId)) {
            System.out.println("Enter your UserName");
            String loginName = sc.nextLine();
            System.out.println("Enter your password");
            String password = sc.nextLine();
            boolean isAdded = userRegistrationModel.addCredentials(userName, password);
            if (!isAdded) {
                showAlert("Error in adding credentials... please reenter the following");
                reEnterUserCredentials();
            } else {
                String str = "User " + userName + " Added Successfully Please Login";
                showAlert(str);
            }

            WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
            welcomeScreenView.init();

        }
    }

    public void reEnterUserCredentials() {
        System.out.println("Enter your UserName");
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        boolean isAdded = userRegistrationModel.addCredentials(userName, password);
        if (!isAdded) {
            showAlert("Error in adding credentials... please reenter the following");
            reEnterUserCredentials();
        } else {
            showAlert("User Added Successfully Please Login");
            // loginView.init();
        }

    }

    private void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}
