package com.easwaran2506.IPMS.candidate;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.interview.InterviewView;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Interview;
import com.easwaran2506.IPMS.model.InterviewLog;

public class CandidateModel {
    private CandidateView candidateView;
    List<Interview> interviewList = new ArrayList<>();

    CandidateModel(CandidateView candidateView) {
        this.candidateView = candidateView;
    }

    int interviewlogid = 1;

    public static List<Company> getCompany() {
        return InterviewDatabase.getInstance().readCompany();
    }

    public static List<Interview> readInterview() {

        return InterviewDatabase.getInstance().readInterview();
    }

    public static List<InterviewLog> readInterviewLog() {

        return InterviewDatabase.getInstance().readInterviewLog();
    }

    public boolean writeInterLog(int candidateId, int interviewId) {
        List<InterviewLog> interviewLogList = new ArrayList<>();

        boolean isAdded = false;
        if (InterviewDatabase.getInstance().readInterviewLog() != null) {
            interviewLogList = InterviewDatabase.getInstance().readInterviewLog();
            interviewlogid = interviewLogList.get(interviewLogList.size() - 1).getInterviewlogid() + 1;
        }
        InterviewLog interviewLog = new InterviewLog();
        for (int i = 0; i < interviewLogList.size(); i++) {
            if ((interviewLogList.get(i).getInterviewid() == interviewId)
                    && (interviewLogList.get(i).getCandidateid() == candidateId)) {
                isAdded = true;
                break;
            }
        }
        if (!isAdded) {
            interviewLog.setCandidateid(candidateId);
            interviewLog.setCurrentstatus("Applied");
            interviewLog.setInterviewid(interviewId);
            interviewLog.setInterviewlogid(interviewlogid);
            interviewLogList.add(interviewLog);
            return InterviewDatabase.getInstance().writeInterviewLog(interviewLogList);

        } else {
            InterviewDatabase.getInstance().loginView.showAlert("Already Applied");
            return false;
        }

    }
}