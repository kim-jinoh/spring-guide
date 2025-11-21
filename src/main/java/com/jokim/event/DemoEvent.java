package com.jokim.event;

public class DemoEvent {
    private final String message;

    public DemoEvent(String message) {
        this.message = message;
    }

    public String getMessage() {   
        return message;
    }
}
