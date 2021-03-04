package com.ekosutrisno.searching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
public class SearchingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchingApplication.class, args);
    }

}
