package com.easwaran2506.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.easwaran2506.dataLayer.LibraryDatabase;

import com.easwaran2506.model.Credentials;
import com.easwaran2506.model.Library;
import com.easwaran2506.model.User;

public class UserRegistrationModel {
    private UserRegistrationView userRegistrationView;
    int userId;
    int candidateId;
    String userEmail;
    int userType;

    public UserRegistrationModel(UserRegistrationView userRegistrationView) {
        this.userRegistrationView = userRegistrationView;
    }

    List<User> userList = new ArrayList<>();

    public List<Library> getLibrary() {
        return LibraryDatabase.getInstance().readLibrary();
    }

    public void setUserId() {
        if (LibraryDatabase.getInstance().readUser() == null)
            userId = 1;
        else {
            userList = LibraryDatabase.getInstance().readUser();
            userId = userList.get(userList.size() - 1).getUserId() + 1;
        }

    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public boolean addUser(String userName, String userAddress,
            long userContact, String userEmail, int libraryId) {
        userType = 2;
        setUserId();
        User user = new User();
        user.setEmail(userEmail);
        user.setMobile(userContact);
        user.setName(userName);
        user.setUserActiveStatus(1);
        user.setUserType(userType);
        user.setUserAddress(userAddress);
        user.setLibraryId(1);
        user.setUserId(userId);
        userList.add(user);
        return LibraryDatabase.getInstance().writeUser(userList);
    }

    public boolean addCredentials(String userName, String password) {
        Credentials credentials = new Credentials();
        credentials.setPassword(password);
        credentials.setUserName(userName);
        credentials.setUserId(userId);
        credentials.setUserType(userType);
        return LibraryDatabase.getInstance().writeCredentials(credentials);
    }

    public boolean isEmailAlreadyExists(String userEmail) {
        boolean isEmail = false;
        if (userList.size() == 0)
            isEmail = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(userEmail.toLowerCase()))
                isEmail = true;
        }
        return isEmail;
    }

}
