package com.easwaran2506.irctc.login;

import java.util.regex.Pattern;

import com.easwaran2506.irctc.dataLayer.TicketDatabase;
import com.easwaran2506.irctc.interfaces.LoginInterface;
import com.easwaran2506.irctc.welcomeScreen.WelcomeScreenView;

public class LoginModel {
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private LoginInterface loginInterface;

    public LoginModel(LoginInterface loginView) {
        this.loginInterface = loginView;

    }

    public void validateUser(String userMobile, String password) {

        if (TicketDatabase.getInstance().isValidUser(userMobile, password)) {
            TicketDatabase.getInstance().redirectToHome(userMobile);
        } else {
            loginInterface.showAlert("User not Found Please Sign Up/Re Login");
            loginInterface.init();
        }

    }

}
