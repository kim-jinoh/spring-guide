package com.jokim.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BDemoHandler {

    @EventListener
    public void handle(DemoEvent event) {
        System.out.println("handle: [" + this.getClass().getName() + "] " + event.getMessage());
    }

}
