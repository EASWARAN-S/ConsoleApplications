package com.easwaran2506.login;

import java.util.Scanner;

import com.easwaran2506.LibraryManagement;

import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class LoginView {
    private LoginModel loginModel;
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    int userType;
    Scanner sc = new Scanner(System.in);

    public LoginView() {
        loginModel = new LoginModel(this);

    }

    public void init() {

        System.out.println(" ------- " + LibraryManagement.getInstance().getAppName() + " ------ \nversion " +
                LibraryManagement.getInstance().getAppVersion());
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
                + LibraryManagement.getInstance().getAppName() + " ------ \nversion " +
                LibraryManagement.getInstance().getAppVersion() + "-----");

    }

    public void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}
