package com.easwaran2506.ticketSystem.dataLayer;

import com.easwaran2506.ticketSystem.interfaces.LoginInterface;
import com.easwaran2506.ticketSystem.login.LoginModel;

public class TicketDatabase {

    private static TicketDatabase ticketDatabase;

    public LoginInterface loginInterface;
    public LoginModel loginModel = new LoginModel(loginInterface);

    public static TicketDatabase getInstance() {
        if (ticketDatabase == null) {
            ticketDatabase = new TicketDatabase();
        }
        return ticketDatabase;

    }

    public boolean isValidUserName(String userName) {
        boolean isValidUser = false;

        if (userName.equals("Admin")) {
            isValidUser = true;

        }
        return isValidUser;
    }

    public String isValidPassword(String password) {
        boolean isValidPassword = false;

        if (password.equals("Admin@123")) {
            isValidPassword = true;
        }

        if (isValidPassword) {
            return "Successfully Login";
        } else {
            return "Password mismatches";
        }
    }

    public boolean isValidEmail(String userEmail) {

        boolean isValidEmail = false;

        if ((userEmail.toLowerCase()).equals("seaswaran007@gmail.com")) {
            isValidEmail = true;
        }

        return isValidEmail;
    }

}