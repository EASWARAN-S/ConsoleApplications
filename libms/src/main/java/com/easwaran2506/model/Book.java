package com.easwaran2506.model;

public class Book {
    private int bookId;
    private String bookName;
    private String bookCatlogueNumber;
    private int bookType;
    /** 1 - Reference 0 not */
    private String bookAuthor;
    private String bookPublisher;
    private int bookStatus;
    private double bookPrice;
    private int isDamaged;
    private String edition;
    private String journer;
    private int availableCount;
    private int volume;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCatlogueNumber() {
        return bookCatlogueNumber;
    }

    public void setBookCatlogueNumber(String bookCatlogueNumber) {
        this.bookCatlogueNumber = bookCatlogueNumber;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getIsDamaged() {
        return isDamaged;
    }

    public void setIsDamaged(int isDamaged) {
        this.isDamaged = isDamaged;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getJourner() {
        return journer;
    }

    public void setJourner(String journer) {
        this.journer = journer;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
