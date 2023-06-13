package com.example.Library.service;

import com.example.Library.Entity.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        if(book!=null){
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book updateBook(int id, Book book) {
        if(book!=null) {
            Book book1 = bookRepository.getById(id);
            if(book1!=null) {
                book1.setBookName(book.getBookName());
                book1.setBookAuthor(book.getBookAuthor());
                book1.setBookPublisher(book.getBookPublisher());
                book1.setBookPublishYear(book.getBookPublishYear());
                book1.setBookQuantity(book.getBookQuantity());
                book1.setBookPrice(book.getBookPrice());
                book1.setBookPriceBorrow(book.getBookPriceBorrow());
                book1.setBookEdition(book.getBookEdition());
                book1.setBookStatus(book.getBookStatus());
                book1.setBookType(book.getBookType());

                return bookRepository.save(book1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteBook(int id) {
        if(id >= 1) {
            Book book = bookRepository.getById(id);
            if(book != null) {
                bookRepository.delete(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }
}