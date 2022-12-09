package com.slawomir_aleksak.spring_second_project.controllers;

import com.slawomir_aleksak.spring_second_project.data.BooksRepository;

import com.slawomir_aleksak.spring_second_project.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books/api")
public class BooksControllerAPI {

    private BooksRepository booksData;

    public BooksControllerAPI(BooksRepository repo) {
        super();
        booksData = repo;
    }

    @GetMapping(value = "/list")
    public List<Book> books() {
        List<Book> allBooks = booksData.findAll();
        return allBooks;
    }

    @PostMapping(value = "/save")
    public String save(Book book) {
        if (book!=null) {
            booksData.save(book);
        }
        return ("redirect:/books/list");
    }

    @GetMapping(value = "/edit/{id}")
    public Book editBook(@PathVariable long id) {
        Optional<Book> book = booksData.findById(id);

        if (book!=null) {
            return book.get();
        } else {
            return books().get(0);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteBook(@PathVariable long id) {
        Optional<Book> book = booksData.findById(id);
        if (book != null) {
            booksData.delete(book.get());
            return true;
        }
        return false;
    }


}














