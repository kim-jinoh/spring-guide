package com.jokim.profile;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final GreetingService greetingService;
    private final Environment environment;

    public ProfileController(GreetingService greetingService, Environment environment) {
        this.greetingService = greetingService;
        this.environment = environment;
    }

    @GetMapping
    public String profile() {
        String activeProfiles = String.join(",", environment.getActiveProfiles());
        if (activeProfiles.isEmpty()) {
            activeProfiles = "default";
        }
        return String.format("%s (active:%s)", greetingService.getProfileName(), activeProfiles);
    }
}


