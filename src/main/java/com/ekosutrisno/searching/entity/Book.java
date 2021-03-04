package com.ekosutrisno.searching.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:31
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column
    private String bookName;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date createdFrom;

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
