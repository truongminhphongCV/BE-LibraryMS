package com.example.Library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private int bookPublishYear;
    private int bookQuantity;
    private double bookPrice;
    private double bookPriceBorrow;
    private int bookEdition;
    private boolean bookStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_type_id")
    @JsonIgnoreProperties("books")
    private BookType bookType;
    public Book() {}

    public Book(String bookName, String bookAuthor, String bookPublisher, int bookPublishYear, int bookQuantity, double bookPrice, double bookPriceBorrow, int bookEdition, boolean bookStatus) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPublishYear = bookPublishYear;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.bookPriceBorrow = bookPriceBorrow;
        this.bookEdition = bookEdition;
        this.bookStatus = bookStatus;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public int getBookPublishYear() {
        return bookPublishYear;
    }

    public void setBookPublishYear(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookPriceBorrow() {
        return bookPriceBorrow;
    }

    public void setBookPriceBorrow(double bookPriceBorrow) {
        this.bookPriceBorrow = bookPriceBorrow;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public BookType getBookType() {
        return bookType;
    }
    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookPublishYear=" + bookPublishYear +
                ", bookQuantity=" + bookQuantity +
                ", bookPrice=" + bookPrice +
                ", bookEdition=" + bookEdition +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
