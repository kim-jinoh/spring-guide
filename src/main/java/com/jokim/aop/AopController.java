package com.jokim.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    private final AopService aopService;

    @Autowired
    public AopController(AopService aopService) {
        this.aopService = aopService;
    }

    @GetMapping("/aop")
    public String aop() {
            aopService.create();
            aopService.doSomething();
            aopService.delete();
            return "aop done";
    }
}
