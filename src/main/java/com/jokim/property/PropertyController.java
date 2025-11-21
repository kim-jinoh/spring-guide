package com.jokim.property;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {
    private final Environment environment;

    public PropertyController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public String property() {
        return String.format("property: %s", environment.getProperty("test.fromresource"));
    }
}
