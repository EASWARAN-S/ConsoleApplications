package com.easwaran2506.IPMS.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.IPMS.candidate.CandidateModel;
import com.easwaran2506.IPMS.candidate.CandidateView;
import com.easwaran2506.IPMS.home.HomeScreenView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Candidate;
import com.easwaran2506.IPMS.model.CandidateRemarks;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Interview;
import com.easwaran2506.IPMS.model.InterviewLog;
import com.easwaran2506.IPMS.model.User;
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
                    addInterview(userType, userId);
                    break;
                case 2:
                    displayInterview(userType, userId);
                    break;
                case 3:
                    assignInterviewers(userType, userId);
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
                    displayInterview(userType, userId);
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

    private void assignInterviewers(int userType, int userId) {
        System.out.println("Assign Interviewers to the Candidate's  Application");
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

        List<Interview> interviewList = interviewModel.readInterview(userCompany);
        String[] interViewName = new String[interviewList.size()];
        int[] interId = new int[interviewList.size()];
        int count = 0;

        for (int i = 0; i < interviewList.size(); i++) {
            if (interviewList.get(i).getCompanyId() == userCompany) {
                interViewName[count] = interviewList.get(i).getInterviewDate() + " - "
                        + interviewList.get(i).getInterviewtime() + " - " + interviewList.get(i).getInterviewRole();
                interId[count++] = interviewList.get(i).getInterviewId();
            }

        }
        for (int j = 0; j < interViewName.length; j++) {
            System.out.println((j + 1) + " . " + interViewName[j]);
        }
        if (interViewName.length != 0) {
            System.out.println("Type your choice ");
            int interview = sc.nextInt();

            sc.nextLine();
            int interviewId = interId[interview - 1];
            List<InterviewLog> interviewLogls = new ArrayList<>();
            interviewLogls = interviewModel.getInterviewCandidates(interviewId);
            List<Candidate> candidateLs = interviewModel.getCandidates();
            int interviewLogId[] = new int[interviewLogls.size()];
            String candidateName[] = new String[interviewLogls.size()];
            int i = 0;
            for (InterviewLog interviewLg : interviewLogls) {
                for (Candidate candidate : candidateLs) {
                    if (interviewLg.getCandidateid() == candidate.getCandidateId()) {
                        interviewLogId[i] = interviewLg.getInterviewlogid();
                        candidateName[i++] = candidate.getCandidateName() + " - " + candidate.getYearOfExeperience()
                                + " year/years of experience";
                        break;
                    }
                }
            }

            List<User> userList = new ArrayList<>();
            userList = interviewModel.getInterviewers(userCompany);
            int interviewerId[] = new int[userList.size()];
            String interviewerName[] = new String[userList.size()];
            int j = 0;
            for (User user : userList) {
                interviewerId[j] = user.getUserId();
                interviewerName[j] = user.getUserName() + " - " + user.getUserDesignation();
                j++;
            }
            if (interviewLogls.size() != 0) {

                System.out.println("Assign Interviewers for Candidates one by one ");
                System.out.println(
                        " Choose the Interviewer Please Enter only numbers no dot allowed after the number for Say enter 1 for first choice and not 1. or one etc ");
                for (int k = 0; k < candidateName.length; k++) {
                    System.out.println("Candidate  Info : " + candidateName[k]);
                    System.out.println();
                    System.out.println("Interviewers");
                    System.out.println();
                    for (int l = 0; l < interviewerName.length; l++) {
                        System.out.println((l + 1) + " . " + interviewerName[l]);
                    }
                    System.out.println("Type your choice ");
                    int interviewerId1 = sc.nextInt();
                    sc.nextLine();
                    if (interviewModel.addCandidateRemarks(interviewerId[interviewerId1 - 1], interviewLogId[k])) {
                        System.out.println("Interviewer Assigned Successfully Thank You");
                    } else {
                        System.out.println("Please Reassign ");
                        assignInterviewers(userType, userId);

                    }
                }
                init(userType, userId);

            } else {
                System.out.println("All Candidates are Assigned....");
                init(userType, userId);
            }
        }

    }

    private void displayInterview(int userType, int userId) {
        System.out.println("It is under construction");
        init(userType, userId);

    }

    private void addInterview(int userType, int userId) {
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
