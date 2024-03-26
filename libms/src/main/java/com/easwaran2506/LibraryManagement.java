package com.easwaran2506;

import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class LibraryManagement {
    private static LibraryManagement libraryManagement;

    private String appName = "LIBMS";

    private String appVersion = "0.1.0";

    private LibraryManagement() {

    }

    public static LibraryManagement getInstance() {
        if (libraryManagement == null) {
            libraryManagement = new LibraryManagement();
        }
        return libraryManagement;
    }

    private void create() {
        WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
        welcomeScreenView.init();
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public static void main(String[] args) {
        LibraryManagement.getInstance().create();
    }
}
