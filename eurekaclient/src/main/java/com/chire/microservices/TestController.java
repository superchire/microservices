package com.chire.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${chire.secret}")
    private String secret;


    @GetMapping("test")
    public String test() {
        return "test_0";
    }



    @GetMapping("secret")
    public String from() {
        return this.secret;
    }
}