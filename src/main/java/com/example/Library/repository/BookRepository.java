package com.example.Library.repository;



import com.example.Library.Entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface BookRepository extends JpaRepository<Book, Integer> {

}







