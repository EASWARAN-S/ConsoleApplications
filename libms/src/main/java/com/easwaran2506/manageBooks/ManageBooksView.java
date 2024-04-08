package com.easwaran2506.manageBooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.easwaran2506.login.LoginView;
import com.easwaran2506.model.Book;
import com.easwaran2506.welcomeScreen.WelcomeScreenView;

public class ManageBooksView {
    private ManageBooksModel manageBooksModel;

    public ManageBooksView() {
        this.manageBooksModel = new ManageBooksModel(this);
    }

    private LoginView loginView = new LoginView();
    private WelcomeScreenView welcomeScreenView = new WelcomeScreenView();

    Scanner sc = new Scanner(System.in);

    public void init(int userId, int userType) {
        if (userType != 3) {
            System.out.println(
                    "\n 1.Add Books \n 2.Display Books   \n 3. Log Out \n 0 Exit \n Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    loginView.showAlert("Thank for you using LIBMS...");
                    break;
                case 1:
                    addBooks(userId, userType);
                    break;
                case 2:
                    showBooks(userId, userType);
                    break;
                case 3:
                    welcomeScreenView.init();
                    break;
                default:
                    loginView.showAlert("Invalid menu choice ... please enter a valid one");
                    init(userType, userId);
                    break;

            }
        }

    }

    private void addBooks(int userId, int userType) {
        System.out.println("Enter the Book Name");
        String bookName = sc.nextLine();
        System.out.println("Enter the Book Catologue Number");
        String bookCatologue = sc.nextLine();
        System.out.println("Enter  the Book Type .. Type 1 for Reference 0 for non reference");
        int bookType = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Author of the Book");
        String author = sc.nextLine();
        System.out.println("Enter the Publisher Name");
        String publisher = sc.nextLine();
        System.out.println("Enter the Book Price");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the Edition");
        String edition = sc.nextLine();
        System.out.println("Enter the Book Category");
        String bookCategory = sc.nextLine();
        if (manageBooksModel.addBooks(userId, bookName, bookCatologue, bookType, author, publisher, price, edition,
                bookCategory)) {
            String msg = bookName + " is added successfully";
            loginView.showAlert(msg);
            init(userId, userType);
        } else {
            loginView.showAlert("Please add the book once again without any errors");
            addBooks(userId, userType);
        }
    }

    private void showBooks(int userId, int userType) {
        System.out.println("Book Informations...");

        List<Book> bookList = new ArrayList<>();
        bookList = manageBooksModel.getBooks(userId, userType);
        if (bookList.size() == 0)
            loginView.showAlert("NO Books Found...");
        else {
            System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s\n", "Book Catlogue Number", "Book Name",
                    "Author of the Book",
                    "Edition of the Book",
                    "Publisher of the Book", "Book Category");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s\n", bookList.get(i).getBookCatlogueNumber(),
                        bookList.get(i).getBookName(), bookList.get(i).getBookAuthor(),
                        bookList.get(i).getEdition(), bookList.get(i).getBookPublisher(),
                        bookList.get(i).getBookCategory());
            }
        }

        init(userId, userType);
    }
}
