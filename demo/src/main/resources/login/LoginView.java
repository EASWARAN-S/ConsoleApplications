package com.easwaran2506.ticketSystem.login;

import java.io.IOException;
import java.util.Scanner;

import com.easwaran2506.ticketSystem.TicketDesk;
import com.easwaran2506.ticketSystem.interfaces.LoginInterface;
import com.easwaran2506.ticketSystem.welcomeScreen.WelcomeScreenView;

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

        System.out.println(" ------- " + TicketDesk.getInstance().getAppName() + " ------ \nversion " +
                TicketDesk.getInstance().getAppVersion());
        System.out.println("\n\n Please Login to Proceed ");

        System.out.println("\n Enter your Email");
        String userEmail = sc.nextLine();
        if (loginModel.isValidEmailid(userEmail)) {
            System.out.println("Enter the User Name");
            String userName = sc.nextLine();
            System.out.println("Enter the password:");
            String password = sc.nextLine();
            loginModel.validateUser(userName, password, userEmail);
        } else {
            showAlert("Email id is not valid please give correct EMail ID");
            init();
        }

    }

    public void onSuccess() {

        System.out.flush();
        System.out.println("\n\n You have Successfully Logined ...\n\n ---- welcome to "
                + TicketDesk.getInstance().getAppName() + " ------ \nversion " +
                TicketDesk.getInstance().getAppVersion() + "-----");

    }

    public void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}
