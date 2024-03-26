package com.easwaran2506.IPMS.maven.demo.src.main.java.com.example;

import com.easwaran2506.IPMS.login.*;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenModel;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;
import com.fasterxml.jackson.core.JsonProcessingException;

public class interviewManagement {
    private static interviewManagement interviewManagement;

    private String appName = "IPMS";

    private String appVersion = "0.1.0";

    private interviewManagement() {

    }

    public static interviewManagement getInstance() {
        if (interviewManagement == null) {
            interviewManagement = new interviewManagement();
        }
        return interviewManagement;
    }

    private void create() throws JsonProcessingException {
        // LoginView loginView = new LoginView();
        // loginView.init();
        WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
        welcomeScreenView.init();
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] args) throws JsonProcessingException {
        interviewManagement.getInstance().create();
    }
}
