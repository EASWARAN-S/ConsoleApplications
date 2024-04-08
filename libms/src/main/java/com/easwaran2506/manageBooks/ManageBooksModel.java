package com.easwaran2506.manageBooks;

import java.util.ArrayList;
import java.util.List;

import com.easwaran2506.dataLayer.LibraryDatabase;
import com.easwaran2506.model.Book;

public class ManageBooksModel {
    private ManageBooksView manageBooksView;

    public ManageBooksModel(ManageBooksView manageBooksView) {
        this.manageBooksView = manageBooksView;
    }

    int bookId;
    List<Book> bookList = new ArrayList<>();

    public int getLibrary(int userId) {
        return LibraryDatabase.getInstance().readGivenUser(userId).getLibraryId();
    }

    public List<Book> getBooks() {
        return LibraryDatabase.getInstance().readBooks();
    }

    public List<Book> getBooks(int libId) {
        List<Book> bookList = new ArrayList<>();

        for (Book book : LibraryDatabase.getInstance().readBooks()) {
            if (book.getLibId() == libId)
                bookList.add(book);
        }
        return bookList;
    }

    public List<Book> getBooks(int userId, int userType) {
        if (userType == 1)
            return getBooks();
        else
            return getBooks(getLibrary(userId));
    }

    public void setBookId(int userId) {

        if ((LibraryDatabase.getInstance().readBooks().size() == 0)
                || (LibraryDatabase.getInstance().readBooks() == null))
            bookId = 1;
        else {
            bookList = LibraryDatabase.getInstance().readBooks();
            bookId = bookList.get(bookList.size() - 1).getBookId() + 1;

        }

    }

    public boolean addBooks(int userId, String bookName, String bookCatologue, int bookType, String author,
            String publisher, double price, String edition, String bookCategory) {
        Book book = new Book();
        setBookId(userId);
        book.setBookId(bookId);
        book.setBookName(bookName);
        book.setBookCatlogueNumber(bookCatologue);
        book.setBookType(bookType);
        book.setBookAuthor(author);
        book.setBookPublisher(publisher);
        book.setBookStatus(1);
        book.setBookPrice(price);
        book.setIsDamaged(0);
        book.setEdition(edition);
        book.setBookCategory(bookCategory);
        book.setLibId(getLibrary(userId));
        bookList.add(book);
        return LibraryDatabase.getInstance().writeBooks(bookList);
    }

}
