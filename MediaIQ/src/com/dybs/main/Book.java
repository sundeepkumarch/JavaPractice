package com.dybs.main;

public class Book {

    private String bookId;
    private int price;
    private String bookName;

    public Book(String bookId, int price, String bookName) {
        this.bookId = bookId;
        this.price = price;
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
