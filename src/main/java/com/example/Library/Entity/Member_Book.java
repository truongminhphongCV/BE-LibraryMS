package com.example.Library.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@Table
public class Member_Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recordId")
    private int recordId;
    private int memberId;
    private int bookId;
    private Date dateBorrow;
    private Date dateReturn;
    private boolean status;
    private int price;

    public Member_Book(int recordId, int memberId, int bookId, Date dateBorrow, boolean status) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateBorrow = dateBorrow;
        this.status = status;
    }

    public Member_Book(int memberId, int bookId, Date dateBorrow) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateBorrow = dateBorrow;
        this.status= false;
    }

    public Member_Book(int memberId, int bookId, Date dateBorrow, Date dateReturn, boolean status) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        if (dateBorrow != null && dateReturn != null) {
            long borrowedMonths = calculateBorrowedMonths(dateBorrow, dateReturn);
            int pricePerMonth = 20000; // Giá tiền mỗi tháng
            this.price = (int) (borrowedMonths * pricePerMonth);
        } else {
            this.price = 0; // Đặt giá trị price thành 0 nếu chưa có thông tin ngày mượn và ngày trả
        }
    }



    private long calculateBorrowedMonths(Date dateBorrow, Date dateReturn) {
        LocalDate borrowLocalDate = dateBorrow.toLocalDate();
        LocalDate returnLocalDate = dateReturn.toLocalDate();
        long borrowedDays = ChronoUnit.DAYS.between(borrowLocalDate, returnLocalDate);
        long borrowedMonths = borrowedDays / 30; // Chia số ngày cho 30 để tính số tháng
        return borrowedMonths + 1;
    }

    public Member_Book(int recordId, int memberId, int bookId, Date dateBorrow, Date dateReturn, boolean status) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.status = status;
    }

    public Member_Book() {
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public boolean isStatus() {
        return status;
    }

}
