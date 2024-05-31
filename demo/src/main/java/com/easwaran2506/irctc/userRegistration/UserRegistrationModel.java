package com.easwaran2506.irctc.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.easwaran2506.irctc.dataLayer.TicketDatabase;

import com.easwaran2506.irctc.model.User;

public class UserRegistrationModel {
    private UserRegistrationView userRegistrationView;
    int userId;
    int userType;

    public UserRegistrationModel(UserRegistrationView userRegistrationView) {
        this.userRegistrationView = userRegistrationView;
    }

    List<User> userList = new ArrayList<>();

    public void setUserId() {
        if (TicketDatabase.getInstance().readUser() == null)
            userId = 1;
        else {
            userList = TicketDatabase.getInstance().readUser();
            userId = userList.get(userList.size() - 1).getUserId() + 1;
        }

    }

    public boolean isMobileNumberExists(String userMobile) {
        boolean isMobileExists = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getMobile().equals(userMobile))
                isMobileExists = true;
        }
        return isMobileExists;
    }

    public boolean addUser(String userMobile, String password, String userName) {
        userType = 2;
        setUserId();
        User user = new User();
        user.setMobile(userMobile);
        user.setUserId(userId);
        user.setName(userName);
        user.setUserType(userType);
        user.setUserActiveStatus(1);
        user.setPassword(password);
        userList.add(user);
        return TicketDatabase.getInstance().writeUser(userList);
    }

}
