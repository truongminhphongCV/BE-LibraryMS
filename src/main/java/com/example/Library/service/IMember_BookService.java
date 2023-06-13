package com.example.Library.service;


import com.example.Library.Entity.Member_Book;

import java.util.List;

public interface IMember_BookService {
    //create Member_Book - Borrow Book
    public Member_Book addMember_Book(Member_Book memberBook);
    // update Member_Book - Return Book
    public Member_Book updateMember_Book(int userId, int bookId,Member_Book memberBook);
    List<Member_Book> getAllMember_Books();
    public List<Member_Book> getMember_BooksByUserId(int userId);

}