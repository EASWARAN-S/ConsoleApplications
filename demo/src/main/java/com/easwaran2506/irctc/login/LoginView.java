package com.easwaran2506.irctc.login;

import java.io.IOException;
import java.util.Scanner;

import com.easwaran2506.irctc.TrainTicketManagementSystem;
import com.easwaran2506.irctc.interfaces.LoginInterface;
import com.easwaran2506.irctc.welcomeScreen.WelcomeScreenView;

// import com.easwaran2506.IPMS.candidate.CandidateView;
// import com.easwaran2506.IPMS.company.CompanyView;
// import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
// import com.easwaran2506.IPMS.interview.InterviewView;
// import com.easwaran2506.IPMS.maven.demo.src.main.java.com.example.*;
// // import com.easwaran2506.IPMS.model.Candidate;
// import com.easwaran2506.IPMS.user.UserView;
// // import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;
// import com.fasterxml.jackson.core.JsonProcessingException;

public class LoginView implements LoginInterface {
    private LoginModel loginModel;
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    Scanner sc = new Scanner(System.in);

    public LoginView() {
        loginModel = new LoginModel(this);

    }

    public void init() {

        System.out.println(" ------- " + TrainTicketManagementSystem.getInstance().getAppName() + " ------ \nversion " +
                TrainTicketManagementSystem.getInstance().getAppVersion());
        System.out.println("\n\n Please Login to Proceed ");

        System.out.println("\n Enter your Mobile Number");
        String userMobile = sc.nextLine();

        System.out.println("Enter the password:");
        String password = sc.nextLine();
        loginModel.validateUser(userMobile, password);

    }

    public void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}
