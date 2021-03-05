package com.ekosutrisno.searching.controller;

import com.ekosutrisno.searching.entity.Book;
import com.ekosutrisno.searching.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpringBootMockResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 16:49
 */

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookController bookController;

    @MockBean
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void getALl() throws Exception {
        List<Book> books = List.of(
                new Book(1, "Eko A", new Date()),
                new Book(2, "Eko B", new Date()),
                new Book(3, "Eko C", new Date())
        );

        when(bookRepository.findAll()).thenReturn(books);


        mockMvc.perform(get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].bookId").value(1));
    }

    @Test
    void getAllByCreatedDate() {
    }

    @Test
    void addBook() throws Exception {
        Book dataBook = new Book(1, "Bagus Berkeratif", new Date());

        when(bookRepository.save(dataBook)).thenReturn(dataBook);

        String data = new ObjectMapper().writeValueAsString(dataBook);

        mockMvc.perform(post("/api/books")
                .contentType(APPLICATION_JSON_VALUE)
                .content(data)
        ).andDo(print())
                .andExpect(status().isCreated());
    }
}