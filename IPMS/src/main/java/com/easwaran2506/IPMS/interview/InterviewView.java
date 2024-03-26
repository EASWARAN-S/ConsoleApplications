package com.easwaran2506.IPMS.interview;

import java.util.List;
import java.util.Scanner;

import com.easwaran2506.IPMS.candidate.CandidateView;
import com.easwaran2506.IPMS.home.HomeScreenView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;

public class InterviewView {
    private InterviewModel interviewModel;
    private LoginView loginView = new LoginView();
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private HomeScreenView homeScreenView = new HomeScreenView();
    Scanner sc = new Scanner(System.in);

    public InterviewView() {
        interviewModel = new InterviewModel(this);
    }

    int userLogId;

    public void init(int userType, int userId) {
        userLogId = userId;
        if (userType == 1) {
            System.out.println(
                    "\n 1. Add Interview  \n 2. Display Interviews \n 3. Assign Interviewers \n 4.Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    addInterview(userType);
                    break;
                case 2:
                    displayInterview(userType);
                    break;
                case 3:
                    assignInterviewers();
                    break;
                case 4:
                    welcomeScreenView.init();
                    break;
                default:
                    loginView.showAlert("Invalid menu choice ... please enter a valid one");
                    init(userType, userLogId);
                    break;

            }
        }
        if (userType == 2) {
            System.out.println(
                    "\n 1. Display Interviews  \n 2. Log Out \n 3. Back \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    displayInterview(userType);
                    break;
                case 2:
                    welcomeScreenView.init();
                    break;
                case 3:
                    homeScreenView.mainMenu(userType, userId);
                    break;
                default:
                    loginView.showAlert("Invalid menu choice ... please enter a valid one");
                    init(userType, userLogId);
                    break;

            }
        }
    }

    private void assignInterviewers() {

    }

    private void displayInterview(int userType) {

    }

    private void addInterview(int userType) {
        System.out.println("Enter the interview date  Date Format must be in dd-mm-yyyy Format");
        String interviewDate = sc.nextLine();
        System.out.println("Enter the interview time  Time Format must be in HH:MM:SS  in railway Time Format");
        String interviewTime = sc.nextLine();
        System.out.println(
                "Choose the company name Please Enter only numbers no dot allowed after the number for Say enter 1 for first choice and not 1. or one etc ");
        List<Company> companyList = interviewModel.getCompany();
        String[] companyName = new String[companyList.size()];
        for (int i = 0; i < companyList.size(); i++) {
            companyName[i] = companyList.get(i).getCompanyName() + " - " + companyList.get(i).getCompanyAddress();

        }
        for (int j = 0; j < companyName.length; j++) {
            System.out.println((j + 1) + " . " + companyName[j]);
        }
        System.out.println("Type your choice ");
        int userCompany = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Job Role");
        String interviewRole = sc.nextLine();
        System.out.println("Enter the Total Score ");
        int score = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the No Of Interviewers");
        int interviewersTotal = sc.nextInt();
        sc.nextLine();
        interviewModel.addInterview(interviewDate, interviewTime, userCompany, interviewRole, score, interviewersTotal);
        init(userType, userLogId);
    }

}
