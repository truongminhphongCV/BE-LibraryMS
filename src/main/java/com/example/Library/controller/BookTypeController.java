package com.example.Library.controller;




import com.example.Library.Entity.BookType;

import com.example.Library.service.IBookTypeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

@RestController

@RequestMapping(path = "api/v1/bookTypes")

public class BookTypeController {

    @Autowired

    private IBookTypeService iBookTypeService;

    @GetMapping("/")

    public String test() {

        return "test api book type";

    }

        @PostMapping("/add")

    public BookType addBookType(@RequestBody BookType bookType) {

        return iBookTypeService.addBookType(bookType);

    }

    @PutMapping("/update")

    public BookType updateBookType(@RequestParam("typeId") int id, @RequestBody BookType bookType) {

        return iBookTypeService.updateBookType(id, bookType);

    }

    @DeleteMapping("/delete")

    public boolean deleteBookType(@RequestParam("typeId") int id) {

        return iBookTypeService.deleteBookType(id);

    }

    @GetMapping("/list")

    public List<BookType> getAllBookTypes() {

        return iBookTypeService.getAllBookTypes();

    }

    @GetMapping("/getById")

    public Optional<BookType> getBookTypeById(@RequestParam("typeId") int id) {

        return iBookTypeService.getBookTypeById(id);

    }

}






