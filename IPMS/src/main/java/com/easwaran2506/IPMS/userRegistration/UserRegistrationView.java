package com.easwaran2506.IPMS.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;

public class UserRegistrationView {
    Scanner sc = new Scanner(System.in);
    private UserRegistrationModel userRegistrationModel;

    public UserRegistrationView() {
        userRegistrationModel = new UserRegistrationModel(this);
    }

    public void init() {

        System.out.println("Welcome to Interview Panel Management System - IPMS");
        for (int i = 0; i < 75; i++)
            System.out.print("-");
        System.out.println();
        mainMenu();

    }

    private void mainMenu() {
        System.out.println("\n Please Choose the relavent option");
        for (int i = 0; i < 50; i++)
            System.out.print("-");
        System.out.println();
        System.out.println("\n 1. Candidate \n 2. Employee \n 3.Logout \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 0:
                InterviewDatabase.getInstance().loginView.showAlert("Thank for you using IPMS...");
                break;
            case 1:
                candidateRegistrationForm();

                break;
            case 2:
                employeeRegistrationForm();
                break;
            case 3:
                WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
                welcomeScreenView.init();

                break;

            default:
                InterviewDatabase.getInstance().loginView.showAlert("Invalid menu choice ... please enter a valid one");
                init();
                break;

        }
    }

    private void candidateRegistrationForm() {
        System.out.println("Enter your Name");
        String candidateName = sc.nextLine();
        System.out.println("Enter your Age");
        int candidateAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your Address");
        String candidateAddress = sc.nextLine();
        System.out.println("Enter your Father's Name ");
        String candidateFatherName = sc.nextLine();
        System.out.println("Enter your Date Of birth use DD-MM-YYYY Format For say 13-12-2000 ");
        String candidateDob = sc.nextLine();
        System.out.println("Enter your Skills Use Commas to separate the skills  ");
        String candidateSkills = sc.nextLine();
        System.out.println("Enter your EmailId ");
        String candidateEmail = sc.nextLine();
        if (!userRegistrationModel.isValidEmail(candidateEmail)) {
            System.out.println("Email id is  wrong Please Reenter it");
            candidateRegistrationForm();
        }
        if (!userRegistrationModel.isCandidateEmailAlreadyExists(candidateEmail)) {
            System.out.println("Email id is already exists  Please try with unique mail Id");
            candidateRegistrationForm();
        }
        System.out.println("Enter your MobileNumber");
        long candidateMobile = sc.nextLong();
        sc.nextLine();
        System.out.println("Are You Experienced Type Yes Or No ");
        String isExp = sc.nextLine();
        boolean isExperienced = isExp.equalsIgnoreCase("YES");
        System.out.println("Enter your years Of Exeperience if not please type 0 . Only whole Numbers are allowed");
        int yearOfExeperience = sc.nextInt();
        sc.nextLine();

        if (userRegistrationModel.addCandidate(candidateName, candidateAge, candidateAddress, candidateFatherName,
                candidateDob, candidateSkills, isExp, candidateMobile, candidateEmail, isExperienced,
                yearOfExeperience)) {
            System.out.println("Enter your UserName");
            String userName = sc.nextLine();
            System.out.println("Enter your password");
            String password = sc.nextLine();
            boolean isAdded = userRegistrationModel.addCandidateCredentials(userName, password);
            if (!isAdded) {
                InterviewDatabase.getInstance().loginView
                        .showAlert("Error in adding credentials... please reenter the following");
                reEnterCandidateCredentials();
            } else
                InterviewDatabase.getInstance().loginView
                        .showAlert("Candidate Added Successfully Please Login");
            InterviewDatabase.getInstance().loginView.init(4);
        }
    }

    private void employeeRegistrationForm() {
        List<Company> companyList = userRegistrationModel.getCompany();
        String[] companyName = new String[companyList.size()];
        for (int i = 0; i < companyList.size(); i++) {
            companyName[i] = companyList.get(i).getCompanyName() + " - " + companyList.get(i).getCompanyAddress();

        }
        System.out.println("Enter your Name");
        String name = sc.nextLine();
        System.out.println("Enter your Address");
        String userAddress = sc.nextLine();
        System.out.println("Enter your EmailId ");
        String userEmail = sc.nextLine();
        if (!userRegistrationModel.isValidEmail(userEmail)) {
            System.out.println("Email id is  wrong Please Reenter it");
            employeeRegistrationForm();
        }
        if (!userRegistrationModel.isEmailAlreadyExists(userEmail)) {
            System.out.println("Email id is already exists  Please try with unique mail Id");
            employeeRegistrationForm();
        }
        System.out.println("Enter your MobileNumber");
        long userMobile = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter your Designation");
        String userDesig = sc.nextLine();
        System.out.println("Enter your DOJ");
        String userDoj = sc.nextLine();
        System.out.println("Choose your Company ");
        for (int j = 0; j < companyName.length; j++) {
            System.out.println((j + 1) + " . " + companyName[j]);
        }
        System.out.println("Type your choice ");
        int userCompany = sc.nextInt();
        sc.nextLine();
        if (userRegistrationModel.addEmployee(name, userAddress, userEmail, userMobile, userDesig, userDoj,
                userCompany)) {
            System.out.println("Enter your UserName");
            String userName = sc.nextLine();
            System.out.println("Enter your password");
            String password = sc.nextLine();
            boolean isAdded = userRegistrationModel.addCredentials(userName, password);
            if (!isAdded) {
                InterviewDatabase.getInstance().loginView
                        .showAlert("Error in adding credentials... please reenter the following");
                reEnterCredentials();
            } else
                InterviewDatabase.getInstance().loginView
                        .showAlert("User Added Successfully Please Login");
            InterviewDatabase.getInstance().loginView.init(1);
        }

    }

    public void reEnterCredentials() {
        System.out.println("Enter your UserName");
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        boolean isAdded = userRegistrationModel.addCredentials(userName, password);
        if (!isAdded) {
            InterviewDatabase.getInstance().loginView
                    .showAlert("Error in adding credentials... please reenter the following");
            reEnterCredentials();
        } else
            InterviewDatabase.getInstance().loginView
                    .showAlert("Candidate Added Successfully Please Login");
        InterviewDatabase.getInstance().loginView.init(4);

    }

    public void reEnterCandidateCredentials() {
        System.out.println("Enter your UserName");
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        boolean isAdded = userRegistrationModel.addCandidateCredentials(userName, password);
        if (!isAdded) {
            InterviewDatabase.getInstance().loginView
                    .showAlert("Error in adding credentials... please reenter the following");
            reEnterCandidateCredentials();
        } else {
            InterviewDatabase.getInstance().loginView
                    .showAlert("User Added Successfully Please Login");
            InterviewDatabase.getInstance().loginView.init(1);
        }

    }

}
