package com.ekosutrisno.searching.controller;

import com.ekosutrisno.searching.entity.Book;
import com.ekosutrisno.searching.repository.BookRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
    public List<Book> getALlByCreatedDate(
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String from,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String to) {

        return bookRepository.findAllByCreatedFromBetween(parseDate(from), parseDate(to));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        book.setCreatedFrom(new Date());
        return bookRepository.save(book);
    }

    private Date parseDate(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

        Date result = null;

        try {
            result = format.parse(dateString);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        return result;
    }
}