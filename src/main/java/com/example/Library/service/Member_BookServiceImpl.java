package com.example.Library.service;

import com.example.Library.Entity.Member_Book;
import com.example.Library.Entity.User;
import com.example.Library.repository.Member_BookRepository;
import com.example.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Member_BookServiceImpl implements IMember_BookService{

    @Autowired
    private Member_BookRepository memberBookRepository;

    @Override
    public Member_Book addMember_Book(Member_Book memberBook) {
        return memberBookRepository.save(memberBook);
    }

    @Override
    public Member_Book updateMember_Book(int userId, int bookId, Member_Book memberBook) {
// Tìm đối tượng Member_Book cần cập nhật trong cơ sở dữ liệu
        Member_Book existingMemberBook = memberBookRepository.findByMemberIdAndBookIdAndStatus(userId, bookId, false);
        if (existingMemberBook != null) {
// Cập nhật thông tin của Member_Book
            existingMemberBook.setDateReturn(memberBook.getDateReturn());
            existingMemberBook.setStatus(true); // Đánh dấu là đã trả sách
            existingMemberBook.setPrice();
// Lưu cập nhật vào cơ sở dữ liệu
            return memberBookRepository.save(existingMemberBook);
        }
        return null; // Trả về null nếu không tìm thấy hoặc không thỏa điều kiện
    }

    @Override
    public List<Member_Book> getAllMember_Books() {
// Truy vấn danh sách Member_Books từ cơ sở dữ liệu
        List<Member_Book> memberBooks = memberBookRepository.findAll();
        return memberBooks;
    }
    @Override
    public List<Member_Book> getMember_BooksByUserId(int userId) {
        return memberBookRepository.findByMemberId(userId);
    }

}