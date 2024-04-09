package com.easwaran2506.IPMS.candidate;

import java.util.List;
import java.util.Scanner;

import com.easwaran2506.IPMS.company.CompanyModel;
import com.easwaran2506.IPMS.home.HomeScreenView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Interview;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;

public class CandidateView {
    Scanner sc = new Scanner(System.in);
    private LoginView loginView = new LoginView();
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
    private CandidateModel candidateModel;

    public CandidateView() {
        candidateModel = new CandidateModel(this);
    }

    public void init(int userType, int candidateid) {
        if (userType == 4) {
            applyInterview(candidateid, userType);
        }

    }

    private void applyInterview(int candidateid, int userType) {
        System.out.println(
                "Choose the company you want to apply name Please Enter only numbers no dot allowed after the number for Say enter 1 for first choice and not 1. or one etc ");
        List<Company> companyList = CandidateModel.getCompany();
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
        List<Interview> interviewList = CandidateModel.readInterview();
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
        for (int j = 0; j < count; j++) {
            System.out.println((j + 1) + " . " + interViewName[j]);
        }
        System.out.println("Type your choice ");
        int interview = sc.nextInt();

        sc.nextLine();
        int interviewId = interId[interview - 1];
        candidateModel.writeInterLog(candidateid, interviewId);
        HomeScreenView homeScreenView = new HomeScreenView();
        homeScreenView.mainMenu(userType, candidateid);

    }

}
