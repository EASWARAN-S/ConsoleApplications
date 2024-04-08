
package com.easwaran2506.dataLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.home.HomeScreenView;
import com.easwaran2506.login.LoginView;
import com.easwaran2506.model.Book;
import com.easwaran2506.model.Credentials;
import com.easwaran2506.model.Library;
import com.easwaran2506.model.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class LibraryDatabase {
    private static LibraryDatabase libraryDatabase;
    public HomeScreenView homeScreenView = new HomeScreenView();

    public static LibraryDatabase getInstance() {
        if (libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    public LoginView loginView = new LoginView();

    String filePathLib = "library.json";
    String filePathUser = "user.json";
    String filePathCred = "cred.json";
    String filePathBook = "book.json";

    int userType;
    int userId;
    int userLibId;

    List<User> userList = new ArrayList<>();
    List<Credentials> credList = new ArrayList<>();
    List<Library> libraryList = new ArrayList<>();

    public void init() {
        userList = LibraryDatabase.getInstance().readUser();
        credList = LibraryDatabase.getInstance().readCredentials();
        libraryList = LibraryDatabase.getInstance().readLibrary();
    }

    public boolean isValidUserName(String userName) {
        boolean isValidUser = false;
        for (int i = 0; i < credList.size(); i++) {
            if ((credList.get(i).getUserName().equals(userName))
                    && (credList.get(i).getUserId() == userId)) {
                isValidUser = true;
                break;
            }
        }
        return isValidUser;
    }

    public void isValidPassword(String password) {
        boolean isValidPassword = false;
        for (int i = 0; i < credList.size(); i++) {
            if ((credList.get(i).getPassword().equals(password))
                    && (credList.get(i).getUserId() == userId)) {
                userType = credList.get(i).getUserType();
                isValidPassword = true;
                break;
            }
        }
        if (isValidPassword) {
            homeScreenView.mainMenu(userType, userId);
        } else {
            loginView.showAlert("Password mismatches");
            loginView.init();
        }
    }

    public boolean isValidEmail(String userEmail) {
        init();
        boolean isValidEmail = false;

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(userEmail.toLowerCase())) {
                isValidEmail = true;
                userId = userList.get(i).getUserId();
                userType = userList.get(i).getUserType();
                userLibId = userList.get(i).getLibraryId();
                break;
            }
        }

        return isValidEmail;
    }

    public List<Library> readLibrary() {
        try {
            List<Library> libraryList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            libraryList = mapper.readValue(new File(filePathLib), new TypeReference<List<Library>>() {
            });
            return libraryList;
        } catch (Exception e) {
            return null;
        }
    }

    public void writeLibrary(List Library) {
        try {
            File file = new File(filePathLib);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, Library);
        } catch (Exception e) {
            loginView.showAlert("Error Occured in adding Library");
        }
    }

    public List<User> readUser() {
        try {
            List<User> userList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(new File(filePathUser), new TypeReference<List<User>>() {
            });
            return userList;
        } catch (Exception e) {
            return null;
        }
    }

    public User readGivenUser(int userId) {
        try {
            User user1 = new User();
            List<User> userList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(new File(filePathUser), new TypeReference<List<User>>() {
            });
            for (User user : userList) {
                if (user.getUserId() == userId)
                    user1 = user;
            }
            return user1;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeUser(List user) {
        try {
            File file = new File(filePathUser);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, user);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding user");
            return false;
        }
    }

    public boolean writeCredentials(Credentials credentials) {
        try {
            List<Credentials> credList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCred);
            if (!file.exists()) {
                file.createNewFile();
            } else {

                credList = mapper.readValue(new File(filePathCred), new TypeReference<List<Credentials>>() {
                });
            }

            credList.add(credentials);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, credList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding user Credentials...");
            return false;
        }
    }

    public List<Credentials> readCredentials() {
        List<Credentials> credList = new ArrayList<>();
        try {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCred);
            if (file.exists()) {

                credList = mapper.readValue(new File(filePathCred), new TypeReference<List<Credentials>>() {
                });
            }

        } catch (Exception e) {
        }
        return credList;
    }

    public List<Book> readBooks() {
        List<Book> bookList = new ArrayList<>();
        try {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathBook);
            if (file.exists()) {

                bookList = mapper.readValue(new File(filePathBook), new TypeReference<List<Book>>() {
                });
            }
            return bookList;

        } catch (Exception e) {
            return null;
        }

    }

    public boolean writeBooks(List<Book> bookList) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathBook);
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, bookList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding Books...");
            return false;
        }
    }
}
