package com.easwaran2506.IPMS.interview;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Candidate;
import com.easwaran2506.IPMS.model.CandidateRemarks;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Interview;
import com.easwaran2506.IPMS.model.InterviewLog;
import com.easwaran2506.IPMS.model.User;

class InterviewModel {
    private InterviewView interviewView;
    private LoginView loginView = new LoginView();
    List<Interview> interviewList = new ArrayList<>();
    List<CandidateRemarks> candidateRemarksList = new ArrayList<>();
    List<InterviewLog> interLog = new ArrayList<>();
    int interviewId = 1;
    int remarksSid = 1;

    InterviewModel(InterviewView interviewView) {
        this.interviewView = interviewView;
    }

    public List<Company> getCompany() {
        return InterviewDatabase.getInstance().readCompany();
    }

    public List<InterviewLog> getInterviewLog() {
        return InterviewDatabase.getInstance().readInterviewLog();
    }

    public List<InterviewLog> getInterviewCandidates(int interviewId) {
        List<InterviewLog> interviewLogls = new ArrayList<>();
        List<InterviewLog> interviewLogls1 = new ArrayList<>();
        interviewLogls = InterviewDatabase.getInstance().readInterviewLog();
        for (InterviewLog interviewLog : interviewLogls) {
            if (interviewLog.getCurrentStatus().equalsIgnoreCase("Applied"))
                interviewLogls1.add(interviewLog);
        }
        return interviewLogls1;
    }

    public List<Interview> readInterview(int userCompany) {
        List<Interview> interviewLs = new ArrayList<>();
        List<Interview> interviewLs1 = new ArrayList<>();
        if (InterviewDatabase.getInstance().readInterview() != null)

        {
            interviewLs1 = InterviewDatabase.getInstance().readInterview();
            for (Interview interview : interviewLs1) {
                if (interview.getCompanyId() == userCompany)
                    interviewLs.add(interview);
            }
        }
        return interviewLs;
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

    public List<Candidate> getCandidates() {
        return InterviewDatabase.getInstance().readCandidate();
    }

    public List<User> getInterviewers(int userCompany) {
        return InterviewDatabase.getInstance().readUser(userCompany);
    }

    public boolean addCandidateRemarks(int interviewerId, int interviewLogId) {
        boolean isAdded = false;
        if (InterviewDatabase.getInstance().readCandidateRemarks() != null) {
            candidateRemarksList = InterviewDatabase.getInstance().readCandidateRemarks();
            remarksSid = candidateRemarksList.get(candidateRemarksList.size() - 1).readCandidateRemarks() + 1;
        }
        CandidateRemarks candidateRemarks = new CandidateRemarks();
        for (int i = 0; i < candidateRemarksList.size(); i++) {
            if ((candidateRemarksList.get(i).getInterviewLogId() == interviewLogId)
                    && (candidateRemarksList.get(i).getInterviewerId() == interviewerId)) {
                isAdded = true;
                break;
            }

        }
        if (!isAdded) {
            interLog = getInterviewLog();
            for (InterviewLog interview : interLog) {
                if (interview.getInterviewlogid() == interviewLogId) {
                    interview.setCurrentStatus("Assigned");
                }
            }
            candidateRemarks.setInterviewLogId(interviewLogId);
            candidateRemarks.setInterviewerId(interviewerId);
            candidateRemarks.setRemarks(null);
            candidateRemarks.setScores(0);
            candidateRemarks.setRemarksSid(remarksSid);
            candidateRemarksList.add(candidateRemarks);
            InterviewDatabase.getInstance().writeInterviewLog(interLog);
            return InterviewDatabase.getInstance().writeCandidateRemarks(candidateRemarksList);
        } else {

            return false;
        }

    }

}
