package com.example.Library.service;

import com.example.Library.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public Book addBook(Book book);

    public Book updateBook(int id, Book book);

    public boolean deleteBook(int id);

    public List<Book> getAllBooks();

    public Optional<Book> getBookById(int id);
}