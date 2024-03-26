package com.easwaran2506.IPMS.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.io.File;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.model.Candidate;
import com.easwaran2506.IPMS.model.Credentials;
import com.easwaran2506.IPMS.model.User;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class LoginModel {
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private LoginView loginView;

    LoginModel(LoginView loginView) {
        this.loginView = loginView;

    }

    public void validateUser(String userName, String password, String userEmail, int type) {

        if (InterviewDatabase.getInstance().isValidEmail(userEmail, type)) {
            if (InterviewDatabase.getInstance().isValidUserName(userName)) {
                InterviewDatabase.getInstance().isValidPassword(password);

            } else {
                loginView.showAlert("UserName Invalid If forget Contact your Administrator");
                loginView.init(type);
            }
        } else {
            loginView.showAlert("Email Id not found Please SignUp");

            welcomeScreenView.init();
        }

    }

    public boolean isValidEmailid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
