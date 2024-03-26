package com.easwaran2506.IPMS.userRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.maven.demo.src.main.java.com.example.interviewManagement;
import com.easwaran2506.IPMS.model.Candidate;
import com.easwaran2506.IPMS.model.Company;
import com.easwaran2506.IPMS.model.Credentials;
import com.easwaran2506.IPMS.model.User;

public class UserRegistrationModel {
    private UserRegistrationView userRegistrationView;
    int userId;
    int candidateId;
    String userEmail;
    int userType;

    public UserRegistrationModel(UserRegistrationView userRegistrationView) {
        this.userRegistrationView = userRegistrationView;
    }

    List<User> userList = new ArrayList<>();
    List<Candidate> candidateList = new ArrayList<>();

    public List<Company> getCompany() {
        return InterviewDatabase.getInstance().readCompany();
    }

    public void setUserId() {
        if (InterviewDatabase.getInstance().readUser() == null)
            userId = 1;
        else {
            userList = InterviewDatabase.getInstance().readUser();
            userId = userList.get(userList.size() - 1).getUserId() + 1;
        }

    }

    public void setCandidateId() {
        if (InterviewDatabase.getInstance().readCandidate() == null)
            candidateId = 1;
        else {
            candidateList = InterviewDatabase.getInstance().readCandidate();
            candidateId = candidateList.get(candidateList.size() - 1).getCandidateId() + 1;
        }
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public boolean addEmployee(String name, String userAddress, String userEmail, long userMobile, String userDesig,
            String userDoj, int userCompany) {
        userType = 2;
        setUserId();
        User user = new User();
        user.setUserAddress(userAddress);
        user.setUserCompanyId(userCompany);
        user.setUserDesignation(userDesig);
        user.setUserDoj(userDoj);
        user.setUserName(name);
        user.setUserMobile(userMobile);
        user.setUserType(userType);

        user.setUserEmail(userEmail.toLowerCase());
        user.setUserId(userId);
        userList.add(user);
        return InterviewDatabase.getInstance().writeUser(userList);

    }

    public boolean addCandidate(String candidateName, int candidateAge, String candidateAddress,
            String candidateFatherName, String candidateDob,
            String candidateSkills, String candidateSkills2, long candidateContact, String candidateEmail,
            boolean isExperienced, int yearOfExeperience) {
        userType = 4;
        setCandidateId();
        Candidate candidate = new Candidate();
        candidate.setCandidateName(candidateName);
        candidate.setCandidateAge(candidateAge);
        candidate.setCandidateAddress(candidateAddress);
        candidate.setCandidateFatherName(candidateFatherName);
        candidate.setCandidateDob(candidateDob);
        candidate.setCandidateSkills(candidateSkills);
        candidate.setCandidateContact(candidateContact);
        candidate.setCandidateEmail(candidateEmail);
        candidate.setIsExperienced(isExperienced);
        candidate.setYearOfExeperience(yearOfExeperience);
        candidate.setIsAppointed(false);
        candidate.setCandidateId(candidateId);
        return InterviewDatabase.getInstance().writeCandidate(candidate);
    }

    public boolean addCredentials(String userName, String password) {
        Credentials credentials = new Credentials();
        credentials.setPassword(password);
        credentials.setUserName(userName);
        credentials.setUserId(userId);
        credentials.setUserType(userType);
        return InterviewDatabase.getInstance().writeCredentials(credentials);
    }

    public boolean addCandidateCredentials(String userName, String password) {
        Credentials credentials = new Credentials();
        credentials.setPassword(password);
        credentials.setUserName(userName);
        credentials.setUserId(candidateId);
        credentials.setUserType(userType);
        return InterviewDatabase.getInstance().writeCredentials(credentials);
    }

    public boolean isEmailAlreadyExists(String userEmail) {
        boolean isEmail = false;
        if (userList.size() == 0)
            isEmail = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserEmail().equals(userEmail.toLowerCase()))
                isEmail = true;
        }
        return isEmail;
    }

    public boolean isCandidateEmailAlreadyExists(String userEmail) {
        boolean isEmail = false;
        if (candidateList.size() == 0)
            isEmail = true;
        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getCandidateEmail().equals(userEmail.toLowerCase()))
                isEmail = true;
        }
        return isEmail;
    }

}
