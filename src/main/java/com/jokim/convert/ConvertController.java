package com.jokim.convert;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ConvertController {

    @GetMapping("/convert/converter/{event}")
    public String convertWithConverter(@PathVariable ConvertedEventByConverter event) {
        return event.toString();
    }

    @GetMapping("/convert/formatter/{event}")
    public String convertWithFormatter(@PathVariable ConvertedEventByFormatter event) {
        return event.toString();
    }

}
