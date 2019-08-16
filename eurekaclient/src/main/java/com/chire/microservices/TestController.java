package com.chire.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${chire.hello}")
    private String hello;


    @GetMapping("test")
    public String test() {
        return "test_0";
    }



    @GetMapping("hello")
    public String from() {
        return this.hello;
    }
}