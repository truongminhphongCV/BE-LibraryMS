package com.example.Library.controller;

import com.example.Library.Entity.Book;
import com.example.Library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping(path = "api/v1/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("/")
    public String test() {
        return "test api book";
    }
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return iBookService.addBook(book);
    }
    @PutMapping("/update")
    public Book updateBook(@RequestParam("bookId") int id, @RequestBody Book book) {
        return iBookService.updateBook(id, book);
    }
    @DeleteMapping("/delete")
    public boolean deleteBook(@RequestParam("bookId") int id) {
        return iBookService.deleteBook(id);
    }
    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return iBookService.getAllBooks();
    }
    @GetMapping("/getById")
    public Optional<Book> getBookById(@RequestParam("bookId") int id) {
        return iBookService.getBookById(id);
    }
}