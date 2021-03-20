package com.ekosutrisno.searching.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:31
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer bookId;

    @Column(nullable = false, length = 100)
    @NotNull
    @Size(min = 3, max = 100)
    private String bookName;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date createdFrom;

    public Book(Integer bookId, String bookName, Date createdFrom) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.createdFrom = createdFrom;
    }

    public Book() {

    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCreatedFrom(Date createdFrom) {
        this.createdFrom = createdFrom;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Date getCreatedFrom() {
        return createdFrom;
    }
}
