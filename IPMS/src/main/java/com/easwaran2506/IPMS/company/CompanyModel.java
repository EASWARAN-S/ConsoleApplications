package com.easwaran2506.IPMS.company;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.maven.demo.src.main.java.com.example.interviewManagement;
import com.easwaran2506.IPMS.model.Company;

public class CompanyModel {

    private CompanyView companyView;
    Company company = new Company();

    public CompanyModel(CompanyView companyView) {
        this.companyView = companyView;
    }

    public boolean validate(String companyName, String companyAddress) {
        List<Company> companyList = new ArrayList<>();
        int companyId = 1;
        if (InterviewDatabase.getInstance().readCompany() != null) {
            companyList = InterviewDatabase.getInstance().readCompany();

            companyId = companyList.get(companyList.size() - 1).getCompanyId() + 1;

        }
        boolean isCompanyExists = false;
        company.setCompanyName(companyName);
        company.setCompanyAddress(companyAddress);
        company.setCompanyId(companyId);
        company.setCompanyStatus(1);
        for (Company company : companyList) {
            if ((company.getCompanyName().equalsIgnoreCase(companyName))
                    && (company.getCompanyAddress().equalsIgnoreCase(companyAddress)))
                isCompanyExists = true;
        }
        if (!isCompanyExists) {
            companyList.add(company);
            InterviewDatabase.getInstance().writeCompany(companyList);
            InterviewDatabase.getInstance().loginView.showAlert("Company Added Successfully");
        } else {
            InterviewDatabase.getInstance().loginView.showAlert("Company Already Exists");
        }
        return isCompanyExists;
    }

}
