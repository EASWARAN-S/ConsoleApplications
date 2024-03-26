package com.easwaran2506.IPMS.home;

import java.util.Scanner;

import com.easwaran2506.IPMS.candidate.CandidateView;
import com.easwaran2506.IPMS.company.CompanyView;
import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.interview.InterviewView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.user.UserView;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;

public class HomeScreenView {

    private LoginView loginView = new LoginView();
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    Scanner sc = new Scanner(System.in);

    public void mainMenu(int userType, int userId) {
        if (userType == 1) {
            System.out.println(
                    "\n 1.Company  \n 2. Manage Interview \n 3. Manage User \n 4.Manage Candidates \n 5. Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    CompanyView companyView = new CompanyView();
                    companyView.init();
                    break;
                case 2:
                    InterviewView interviewView = new InterviewView();
                    interviewView.init(userType, userId);

                    break;
                case 3:
                    UserView userView = new UserView();
                    userView.init();
                    break;
                case 4:
                    CandidateView candidateView = new CandidateView();
                    candidateView.init(1, userId);
                    break;
                case 5:
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
                    "\n 1.Add Candidate Remarks \n 2.Interview  \n 3. Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    CandidateView candidateView = new CandidateView();
                    candidateView.init(userType, userId);
                    break;
                case 2:
                    InterviewView interviewView = new InterviewView();
                    interviewView.init(userType, userId);

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
        if (userType == 3) {
            System.out.println(
                    "\n 1.Add Candidates Remarks \n 2. Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    CandidateView candidateView = new CandidateView();
                    candidateView.init(userType, userId);
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

        if (userType == 4) {
            System.out.println(
                    "\n 1.Apply For Interview \n 2. Log Out  \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using IPMS...");
                    break;
                case 1:
                    CandidateView candidateView = new CandidateView();
                    candidateView.init(userType, userId);
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
