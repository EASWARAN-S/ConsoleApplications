package com.easwaran2506.IPMS.dataLayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.IPMS.home.HomeScreenView;
import com.easwaran2506.IPMS.interview.InterviewView;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.model.Candidate;
import com.easwaran2506.IPMS.model.CandidateRemarks;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Credentials;
import com.easwaran2506.IPMS.model.Interview;
import com.easwaran2506.IPMS.model.InterviewLog;
import com.easwaran2506.IPMS.model.InterviewerList;
import com.easwaran2506.IPMS.model.User;
import com.easwaran2506.IPMS.welcomeScreen.WelcomeScreenView;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class InterviewDatabase {

    private static InterviewDatabase interviewDatabase;
    String filePathCompany = "company.json";
    String filePathUser = "user.json";
    String filePathCred = "cred.json";
    String filePathCandidate = "candidate.json";
    String filePathInterview = "interview.json";
    String filePathInterviewLog = "interviewLog.json";
    String filePathCandidteRemarks = "candidateRemarks.json";

    int userType;
    int userId;
    int userCompanyId;

    List<User> userList = new ArrayList<>();
    List<Credentials> credList = new ArrayList<>();
    List<Candidate> candidateList = new ArrayList<>();

    public void init() {
        userList = InterviewDatabase.getInstance().readUser();
        credList = InterviewDatabase.getInstance().readCredentials();
        candidateList = InterviewDatabase.getInstance().readCandidate();
    }

    public LoginView loginView = new LoginView();

    public WelcomeScreenView welcomeScreenView;
    protected InterviewView interviewView;
    public HomeScreenView homeScreenView = new HomeScreenView();

    public static InterviewDatabase getInstance() {
        if (interviewDatabase == null) {
            interviewDatabase = new InterviewDatabase();
        }
        return interviewDatabase;

    }

    public boolean isValidUserName(String userName) {
        boolean isValidUser = false;
        for (int i = 0; i < credList.size(); i++) {
            if ((credList.get(i).getUserName().equals(userName))
                    && (credList.get(i).getUserId() == userId) && (credList.get(i).getUserType() == userType)) {
                isValidUser = true;
                break;
            }
        }
        return isValidUser;
    }

    public void isValidPassword(String password) {
        boolean isValidPassword = false;
        for (int i = 0; i < credList.size(); i++) {
            if ((credList.get(i).getPassword().equals(password))
                    && (credList.get(i).getUserId() == userId) && (credList.get(i).getUserType() == userType)) {
                isValidPassword = true;
                break;
            }
        }
        if (isValidPassword) {
            homeScreenView.mainMenu(userType, userId);
        } else {
            loginView.showAlert("Password mismatches");
            loginView.init(userType);
        }
    }

    public boolean isValidEmail(String userEmail, int type) {
        init();
        boolean isValidEmail = false;
        if (type != 4) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserEmail().equals(userEmail.toLowerCase())) {
                    isValidEmail = true;
                    userId = userList.get(i).getUserId();
                    userType = userList.get(i).getUserType();
                    userCompanyId = userList.get(i).getUserCompanyId();
                    break;
                }
            }
        } else {
            for (int i = 0; i < candidateList.size(); i++) {
                if (candidateList.get(i).getCandidateEmail().equals(userEmail.toLowerCase())) {
                    isValidEmail = true;
                    userId = candidateList.get(i).getCandidateId();
                    userType = type;
                    break;
                }
            }
        }

        return isValidEmail;
    }

    public List<Company> readCompany() {
        try {
            List<Company> companyList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            companyList = mapper.readValue(new File(filePathCompany), new TypeReference<List<Company>>() {
            });
            return companyList;
        } catch (Exception e) {
            return null;
        }
    }

    public void writeCompany(List company) {
        try {
            File file = new File(filePathCompany);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, company);
        } catch (Exception e) {
            loginView.showAlert("Error Occured in adding Company");
        }
    }

    public List<User> readUser() {
        try {
            List<User> userList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(new File(filePathUser), new TypeReference<List<User>>() {
            });
            return userList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeUser(List user) {
        try {
            File file = new File(filePathUser);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, user);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding user");
            return false;
        }
    }

    public boolean writeCredentials(Credentials credentials) {
        try {
            List<Credentials> credList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCred);
            if (!file.exists()) {
                file.createNewFile();
            } else {

                credList = mapper.readValue(new File(filePathCred), new TypeReference<List<Credentials>>() {
                });
            }

            credList.add(credentials);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, credList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding user Credentials...");
            return false;
        }
    }

    public List<Credentials> readCredentials() {
        List<Credentials> credList = new ArrayList<>();
        try {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCred);
            if (file.exists()) {

                credList = mapper.readValue(new File(filePathCred), new TypeReference<List<Credentials>>() {
                });
            }

        } catch (Exception e) {
        }
        return credList;
    }

    public List<Candidate> readCandidate() {
        List<Candidate> candidateList = new ArrayList<>();
        try {

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCandidate);
            if (file.exists()) {

                candidateList = mapper.readValue(new File(filePathCandidate), new TypeReference<List<Candidate>>() {
                });
            }

        } catch (Exception e) {
        }
        return candidateList;

    }

    public boolean writeCandidate(Candidate candidate) {
        init();

        candidateList.add(candidate);
        try {
            File file = new File(filePathCandidate);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, candidateList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding Candidates Contact Administartor");
            return false;
        }
    }

    public List<Interview> readInterview() {
        List<Interview> interviewList = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathInterview);
            if (file.exists()) {

                interviewList = mapper.readValue(new File(filePathInterview), new TypeReference<List<Interview>>() {
                });
                return interviewList;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public boolean writeInterview(List<Interview> interviewList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathInterview);
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, interviewList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while adding Interview ...");
            return false;
        }
    }

    public List<InterviewLog> readInterviewLog() {
        try {
            List<InterviewLog> interviewlogList = new ArrayList<>();
            File file = new File(filePathInterviewLog);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            interviewlogList = mapper.readValue(new File(filePathInterviewLog),
                    new TypeReference<List<InterviewLog>>() {
                    });
            return interviewlogList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<InterviewLog> readInterviewLog(int interviewId) {
        try {
            List<InterviewLog> interviewlogList = new ArrayList<>();
            List<InterviewLog> interviewlogList1 = new ArrayList<>();
            File file = new File(filePathInterviewLog);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            interviewlogList = mapper.readValue(new File(filePathInterviewLog),
                    new TypeReference<List<InterviewLog>>() {
                    });
            for (InterviewLog interviewLog : interviewlogList) {
                if (interviewLog.getInterviewid() == interviewId)
                    interviewlogList1.add(interviewLog);
            }
            return interviewlogList1;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeInterviewLog(List<InterviewLog> interviewLogList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathInterviewLog);
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, interviewLogList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while applying Interview ...");
            return false;
        }
    }

    public List<User> readUser(int userCompany) {
        try {
            List<User> userList = new ArrayList<>();
            List<User> userList1 = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            userList1 = mapper.readValue(new File(filePathUser), new TypeReference<List<User>>() {
            });
            for (User user : userList1) {
                if (user.getUserCompanyId() == userCompany)
                    userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CandidateRemarks> readCandidateRemarks() {
        try {
            List<CandidateRemarks> candidateRemarksList = new ArrayList<>();
            File file = new File(filePathCandidteRemarks);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            candidateRemarksList = mapper.readValue(new File(filePathInterviewLog),
                    new TypeReference<List<CandidateRemarks>>() {
                    });
            return candidateRemarksList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean writeCandidateRemarks(List<CandidateRemarks> candidateRemarksList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePathCandidteRemarks);
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, candidateRemarksList);
            return true;
        } catch (Exception e) {
            loginView.showAlert("Error Occured while assigning interviewer ...");
            return false;
        }
    }

}