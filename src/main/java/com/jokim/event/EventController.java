package com.jokim.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    private final ApplicationEventPublisher publisher;

    public EventController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping
    public String event(@RequestParam(value = "message", defaultValue = "test") String message) {
        publisher.publishEvent(new DemoEvent(message));
        return "do event";
    }
}
