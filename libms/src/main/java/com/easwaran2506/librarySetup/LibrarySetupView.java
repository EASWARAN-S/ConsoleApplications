package com.easwaran2506.librarySetup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.model.*;
import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class LibrarySetupView {
    public Library library = new Library();
    private LibrarySetupModel librarySetupModel;
    Scanner sc = new Scanner(System.in);

    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }

    public void init(int userId, int userType) {
        System.out.println(
                "\n 1.Add Library \n 2. Display Library \n 3.Log Out  \n 0 Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 0:
                showAlert("Thank for you using LIBMS...");
                break;
            case 1:
                initiateSetup(userId, userType);
                break;
            case 2:
                showLibraryDetails(userId, userType);

                break;
            case 3:

                WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
                welcomeScreenView.init();
                break;
            default:
                showAlert("Invalid menu choice ... please enter a valid one");
                init(userId, userType);
                break;

        }
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void initiateSetup(int userId, int userType) {
        System.out.println("\n Enter the Library Name");
        String libName = sc.nextLine();
        System.out.println("\n Enter the Library email id ");
        String libEmail = sc.nextLine();
        System.out.println("\n Enter the Library mobile number  ");
        String libMobile = sc.nextLine();
        System.out.println("\n Enter the Library Incharge Name");
        String libIncharge = sc.nextLine();
        System.out.println("\n Enter the Library Address");
        String libAddr = sc.nextLine();
        librarySetupModel.addLibrary(libName, libEmail, libAddr, libIncharge, libMobile);
        init(userId, userType);
    }

    public void showLibraryDetails(int userId, int userType) {
        System.out.println("Library Informations...");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Library Name", "Library Address", "Librarian Name",
                "Library Email Id", "Library Mobile Number");
        List<Library> libraryList = new ArrayList<>();
        libraryList = librarySetupModel.getLibrary();
        for (int i = 0; i < libraryList.size(); i++) {
            System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", libraryList.get(i).getLibraryName(),
                    libraryList.get(i).getLibraryAddress(), libraryList.get(i).getLibraryInchargeName(),
                    libraryList.get(i).getEmailId(), libraryList.get(i).getPhoneNo());
        }
        init(userId, userType);
    }
}
