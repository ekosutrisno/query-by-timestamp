package com.ekosutrisno.searching.controller;

import com.ekosutrisno.searching.entity.Promotion;
import com.ekosutrisno.searching.repository.PromotionRepository;
import com.ekosutrisno.searching.utils.ParseDateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 15:02
 */
@RestController
@RequestMapping(path = "/api/promotions", produces = APPLICATION_JSON_VALUE)
public class PromotionController {

    private final PromotionRepository promotionRepository;

    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @GetMapping
    public List<Promotion> getAll() {
        return promotionRepository.findAll();
    }

    @GetMapping("/filter")
    public List<Promotion> getAllFilter(
            @RequestParam(value = "validFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String validFrom,
            @RequestParam(value = "validTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String validTo) {

        return promotionRepository.findFilterByValidFromAndValidTo(
                ParseDateUtil.getDate(validFrom),
                ParseDateUtil.getDate(validTo));
    }

    @PostMapping
    public Promotion insertPromotion(@RequestBody Promotion promotion) {
        promotion.setValidFrom(new Date());
        promotion.setValidTo(new Date());
        return promotionRepository.save(promotion);
    }
}
