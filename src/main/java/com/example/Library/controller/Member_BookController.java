package com.example.Library.controller;

import com.example.Library.Entity.Member_Book;
import com.example.Library.config.NotFoundException;
import com.example.Library.repository.Member_BookRepository;
import com.example.Library.service.IMember_BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memberbook")
public class Member_BookController {
    @Autowired
    private IMember_BookService iMemberBookService;

    @GetMapping("/")
    public List<Member_Book> getAllMemberBooks() {
        List<Member_Book> memberBooks = iMemberBookService.getAllMember_Books();
        return memberBooks;
    }

    @PostMapping("/add")
    public ResponseEntity<Member_Book> addMemberBook(@RequestBody Member_Book memberBook) {
        Member_Book addedMemberBook = iMemberBookService.addMember_Book(memberBook);
        return ResponseEntity.ok(addedMemberBook);
    }

    @PutMapping("/")
    public ResponseEntity<Member_Book> updateMemberBook(
            @RequestParam("userId") int userId,

            @RequestParam("bookId") int bookId,
            @RequestBody Member_Book memberBook) {
        try {
            Member_Book updatedMemberBook = iMemberBookService.updateMember_Book(userId, bookId, memberBook);
            return ResponseEntity.ok(updatedMemberBook);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Member_Book>> getMemberBooksByUserId(@PathVariable int userId) {
        List<Member_Book> memberBooks = iMemberBookService.getMember_BooksByUserId(userId);

        if (memberBooks.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(memberBooks);
        }
    }
}
