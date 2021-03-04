package com.ekosutrisno.searching.repository;

import com.ekosutrisno.searching.entity.Book;
import com.ekosutrisno.searching.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 14:59
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    @Query("SELECT p FROM Promotion p WHERE p.validFrom >= ?1 AND p.validTo <= ?2")
    List<Promotion> findFilterByValidFromAndValidTo(Date validFrom, Date validTo);
}
