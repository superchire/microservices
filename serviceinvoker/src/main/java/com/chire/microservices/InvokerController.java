package com.chire.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("router")
    public String router() {
        //這邊會根據名稱(service-provider)去eureka-server取得對應的URL
        String url = "http://service-provider/test";
        return restTemplate.getForObject(url, String.class);
    }

}
