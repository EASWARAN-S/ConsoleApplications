package com.easwaran2506.login;

import java.util.regex.Pattern;

import com.easwaran2506.dataLayer.LibraryDatabase;

import com.easwaran2506.welcomeScreen.WelcomeScreenView;

class LoginModel {
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private LoginView loginView;

    LoginModel(LoginView loginView) {
        this.loginView = loginView;

    }

    public void validateUser(String userName, String password, String userEmail) {

        if (LibraryDatabase.getInstance().isValidEmail(userEmail)) {
            if (LibraryDatabase.getInstance().isValidUserName(userName)) {
                LibraryDatabase.getInstance().isValidPassword(password);

            } else {
                loginView.showAlert("UserName Invalid If forget Contact your Administrator");
                loginView.init();
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
