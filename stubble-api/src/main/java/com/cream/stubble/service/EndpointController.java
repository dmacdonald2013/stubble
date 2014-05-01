package com.cream.stubble.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {
    @RequestMapping("/")
    public String index() {
        return "foo";
    }
}
