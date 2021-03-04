package com.ekosutrisno.searching.controller;

import com.ekosutrisno.searching.entity.Book;
import com.ekosutrisno.searching.repository.BookRepository;
import com.ekosutrisno.searching.utils.ParseDateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:32
 */
@RestController
@RequestMapping(path = "/api/books", produces = APPLICATION_JSON_VALUE)
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getALl() {
        return bookRepository.findAll();
    }

    @GetMapping("/filter")
    public List<Book> getAllByCreatedDate(
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String to) {

        return bookRepository.findAllByCreatedFromBetween(
                ParseDateUtil.getDate(from),
                ParseDateUtil.getDate(to));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        book.setCreatedFrom(new Date());
        return bookRepository.save(book);
    }

}