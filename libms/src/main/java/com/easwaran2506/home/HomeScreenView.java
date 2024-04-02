package com.easwaran2506.home;

import java.util.Scanner;

import com.easwaran2506.librarySetup.LibrarySetupView;
import com.easwaran2506.login.LoginView;
import com.easwaran2506.manageBooks.ManageBooksView;
import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class HomeScreenView {

    private LoginView loginView = new LoginView();
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    Scanner sc = new Scanner(System.in);

    public void mainMenu(int userType, int userId) {
        if (userType == 1) {
            System.out.println(
                    "\n 1. Manage Library   \n 2. Manage Books \n 3.Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using LIBMS...");
                    break;
                case 1:
                    LibrarySetupView librarySetupView = new LibrarySetupView();
                    librarySetupView.init(userId, userType);
                    break;
                case 2:
                    ManageBooksView manageBooksView = new ManageBooksView();
                    manageBooksView.init(userId, userType);
                    break;
                case 3:
                    welcomeScreenView.init();
                    break;
                default:
                    loginView.showAlert("Invalid menu choice ... please enter a valid one");
                    mainMenu(userType, userId);
                    break;

            }
        }

        if (userType == 2) {
            System.out.println(
                    "\n 1.Manage Books \n 2.Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using LIBMS...");
                    break;
                case 1:
                    ManageBooksView manageBooksView = new ManageBooksView();
                    manageBooksView.init(userId, userType);
                    break;
                case 2:

                    welcomeScreenView.init();
                    break;
                default:
                    loginView.showAlert("Invalid menu choice ... please enter a valid one");
                    mainMenu(userType, userId);
                    break;

            }
        }

    }

}
