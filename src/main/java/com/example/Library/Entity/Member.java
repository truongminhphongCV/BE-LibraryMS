package com.example.Library.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String memberAvt;
    private String memberName;
    private String memberAddress;
    private String memberPhone;
    private String memberEmail;
    private Date memberDoB;

    public Member() {

    }

    public Member(int memberId, String memberAvt, String memberName, String memberAddress,
                  String memberPhone, String memberEmail, Date memberDoB) {
        this.memberId = memberId;
        this.memberAvt = memberAvt;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.memberDoB = memberDoB;
    }

    public void setMemberAvt(String memberAvt) {
        this.memberAvt = memberAvt;
    }

    public void getMemberAvt(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberDoB(Date memberDoB) {
        this.memberDoB = memberDoB;
    }

    ////
    public int getMemberId() {
        return this.memberId;
    }

    public String getMemberAvt() {
        return this.memberAvt;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getMemberAddress() {
        return this.memberAddress;
    }

    public String getMemberPhone() {
        return this.memberPhone;
    }

    public String getMemberEmail() {
        return this.memberEmail;
    }

    public Date getMemberDoB() {
        return this.memberDoB;
    }
}