package com.easwaran2506.ticketSystem.login;

import java.util.regex.Pattern;

import com.easwaran2506.ticketSystem.welcomeScreen.WelcomeScreenView;

import com.easwaran2506.ticketSystem.dataLayer.TicketDatabase;
import com.easwaran2506.ticketSystem.interfaces.LoginInterface;

public class LoginModel {
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private LoginInterface loginInterface;

    public LoginModel(LoginInterface loginView) {
        this.loginInterface = loginView;

    }

    public void validateUser(String userName, String password, String userEmail) {

        if (TicketDatabase.getInstance().isValidEmail(userEmail)) {
            if (TicketDatabase.getInstance().isValidUserName(userName)) {
                loginInterface.showAlert(TicketDatabase.getInstance().isValidPassword(password));

            } else {
                loginInterface.showAlert("UserName Invalid If forget Contact your Administrator");
                loginInterface.init();
            }
        } else {
            loginInterface.showAlert("Email Id not found Please SignUp");

            welcomeScreenView.init();
        }

    }

    public boolean isValidEmailid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
