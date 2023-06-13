package com.example.Library.service;

import com.example.Library.Entity.BookType;

import java.util.List;
import java.util.Optional;

public interface IBookTypeService {
    public BookType addBookType(BookType bookType);

    public BookType updateBookType(int id, BookType bookType);

    public boolean deleteBookType(int id);

    public List<BookType> getAllBookTypes();

    public Optional<BookType> getBookTypeById(int id);
}