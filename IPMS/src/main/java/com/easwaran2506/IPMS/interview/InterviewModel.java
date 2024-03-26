package com.easwaran2506.IPMS.interview;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Interview;

class InterviewModel {
    private InterviewView interviewView;
    private LoginView loginView = new LoginView();
    List<Interview> interviewList = new ArrayList<>();
    int interviewId = 1;

    InterviewModel(InterviewView interviewView) {
        this.interviewView = interviewView;
    }

    public List<Company> getCompany() {
        return InterviewDatabase.getInstance().readCompany();
    }

    public List<Interview> readInterview(int userType) {

        return interviewList;
    }

    public boolean addInterview(String interviewDate, String interviewTime, int userCompany, String interviewRole,
            int score, int interviewersTotal) {

        boolean isAdded = false;
        if (InterviewDatabase.getInstance().readInterview() != null) {
            interviewList = InterviewDatabase.getInstance().readInterview();
            interviewId = interviewList.get(interviewList.size() - 1).getInterviewId() + 1;
        }
        Interview interview = new Interview();
        for (int i = 0; i < interviewList.size(); i++) {
            if ((interviewList.get(i).getInterviewDate().equals(interviewDate)) &&
                    (interviewList.get(i).getCompanyId() == userCompany) &&
                    (interviewList.get(i).getInterviewRole().equals(interviewRole)) &&
                    (interviewList.get(i).getInterviewtime().equals(interviewTime))) {
                isAdded = true;
                break;
            }

        }
        if (!isAdded) {
            interview.setCompanyId(userCompany);
            interview.setInterviewDate(interviewDate);
            interview.setInterviewtime(interviewTime);
            interview.setInterviewRole(interviewRole);
            interview.setIndividualScoreLimit(score);
            interview.setNoOfInterviewers(interviewersTotal);
            interview.setInterviewId(interviewId);
            interviewList.add(interview);
            return InterviewDatabase.getInstance().writeInterview(interviewList);
        } else {
            loginView.showAlert("Interview is added already please ignore duplication");
            return false;
        }

    }

}
