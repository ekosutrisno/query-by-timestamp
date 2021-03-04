package com.ekosutrisno.searching.repository;

import com.ekosutrisno.searching.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:32
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByCreatedFromBetween(Date from, Date to);

}