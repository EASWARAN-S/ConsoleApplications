package com.easwaran2506.IPMS.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.IPMS.dataLayer.InterviewDatabase;
import com.easwaran2506.IPMS.login.LoginView;
import com.easwaran2506.IPMS.maven.demo.src.main.java.com.example.interviewManagement;
import com.easwaran2506.IPMS.model.Company;

public class CompanyView {
    private CompanyModel companyModel;
    private LoginView loginView = new LoginView();

    public CompanyView() {
        companyModel = new CompanyModel(this);
    }

    Scanner sc = new Scanner(System.in);

    public void init() {
        System.out.println("\n 1. Add Company \n 2. View Company Info \n 3.Logout \n 0. Exit \n Enter Your Choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 0:
                loginView.showAlert("Thank for you using IPMS...");
                break;
            case 1:
                addCompany();
                break;
            case 2:
                displayCompanyInfo();
                break;
            case 3:
                InterviewDatabase.getInstance().welcomeScreenView.init();
                break;

            default:
                loginView.showAlert("Invalid menu choice ... please enter a valid one");
                init();
                break;

        }
    }

    private void displayCompanyInfo() {
        for (int i = 0; i <= 50; i++)
            System.out.print("-");
        System.out.println("\n\t\t Company Information \t\t");
        for (int i = 0; i <= 50; i++)
            System.out.print("-");
        System.out.println();
        List<Company> companyList = new ArrayList<>();
        if (InterviewDatabase.getInstance().readCompany() != null) {
            companyList = InterviewDatabase.getInstance().readCompany();
            for (Company company : companyList) {
                System.out.println(" Company Name is\t\t: " + company.getCompanyName());
                System.out.println(" Company Address is \t \t: " + company.getCompanyAddress());
            }

            loginView.showAlert("Informations are Displayed");
            init();

        } else {
            loginView.showAlert("No Companies  are Added");
            init();
        }

    }

    public void addCompany() {

        System.out.println("Enter your Company Name");
        String companyName = sc.nextLine();

        System.out.println("Enter your Company  Address");
        String companyAddress = sc.nextLine();
        companyModel.validate(companyName, companyAddress);
        init();
    }

    // private void checkForAddNewCompany() {
    // System.out.println("\nDo you want to add Company? \nType Yes/No");
    // String choice = sc.next();
    // if (choice.equalsIgnoreCase("yes")) {
    // addCompany();
    // } else if (choice.equalsIgnoreCase("no")) {
    // init();
    // } else {
    // System.out.println("\nInvalid choice, Please enter valid choice.\n");
    // checkForAddNewCompany();
    // }
    // }
}
