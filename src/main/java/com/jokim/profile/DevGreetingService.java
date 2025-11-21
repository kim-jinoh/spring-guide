package com.jokim.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prod|dev")
public class DevGreetingService implements GreetingService {

    @Override
    public String getProfileName() {
        return "dev";
    }
}


