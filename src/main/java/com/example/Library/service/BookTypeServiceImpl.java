package com.example.Library.service;

import com.example.Library.Entity.BookType;
import com.example.Library.repository.BookTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTypeServiceImpl implements IBookTypeService{
    @Autowired
    private BookTypeRepository bookTypeRepository;

    @Override
    public BookType addBookType(BookType bookType) {
        if(bookType!=null) {
            return bookTypeRepository.save(bookType);
        }
        return null;
    }

    @Override
    public BookType updateBookType(int id, BookType bookType) {
        if(bookType!=null) {
            BookType bookType1 = bookTypeRepository.getById(id);
            if(bookType1!=null) {
                bookType1.setTypeName(bookType.getTypeName());
                return bookTypeRepository.save(bookType1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteBookType(int id) {
        if(id >= 1) {
            BookType bookType = bookTypeRepository.getById(id);
            if(bookType != null) {
                bookTypeRepository.delete(bookType);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BookType> getAllBookTypes() {
        return bookTypeRepository.findAll();
    }

    @Override
    public Optional<BookType> getBookTypeById(int id) {
        return bookTypeRepository.findById(id);
    }
}