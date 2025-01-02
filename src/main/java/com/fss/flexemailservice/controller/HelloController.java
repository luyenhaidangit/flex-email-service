package com.fss.flexemailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/check")
    public void checkConnection() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM DUAL", Integer.class);
        System.out.println("Connected to DB. Count from DUAL: " + count);
    }
}