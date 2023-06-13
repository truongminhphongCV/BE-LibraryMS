package com.example.Library.repository;

import com.example.Library.Entity.Member_Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface Member_BookRepository extends JpaRepository<Member_Book, Integer> {
    Member_Book findByMemberIdAndBookIdAndStatus(int memberId, int bookId, boolean status);
    List<Member_Book> findByMemberId(int userId);

}
