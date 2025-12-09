package com.jokim.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {

    @GetMapping("/mvctest")
    public String mvctest() {
        return "Hello, World!";
    }
}


