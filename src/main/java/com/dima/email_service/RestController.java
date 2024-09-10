package com.dima.email_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @GetMapping("/task/{type}")
    public String createTask() throws Exception {
        if (new Random().nextBoolean()) {
            throw new Exception("An exception occurred");
        }
        return "Great success!";
    }
}
