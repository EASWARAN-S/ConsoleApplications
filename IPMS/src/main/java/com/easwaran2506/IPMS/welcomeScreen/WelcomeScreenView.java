package com.easwaran2506.IPMS.welcomeScreen;

import java.util.Scanner;

import com.easwaran2506.IPMS.candidate.CandidateView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.maven.demo.src.main.java.com.example.interviewManagement;
import com.easwaran2506.IPMS.userRegistration.UserRegistrationView;
import com.fasterxml.jackson.core.JsonProcessingException;

public class WelcomeScreenView {
    private WelcomeScreenModel welcomeScreenModel;
    Scanner sc = new Scanner(System.in);

    public WelcomeScreenView() {
        welcomeScreenModel = new WelcomeScreenModel(this);
    }

    public void init() {
        System.out.println(" ------- " + interviewManagement.getInstance().getAppName() + " ------ \nversion " +
                interviewManagement.getInstance().getAppVersion());
        System.out.println("\n 1. Employee Login \n 2. signUp  \n 3. Candidate Login \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        LoginView loginView = new LoginView();
        switch (choice) {
            case 0:
                showAlert("Thank for you using IPMS...");
                break;
            case 1:

                loginView.init(1);

                break;
            case 2:
                UserRegistrationView userRegistrationView = new UserRegistrationView();
                userRegistrationView.init();
                break;
            case 3:

                loginView.init(4);

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