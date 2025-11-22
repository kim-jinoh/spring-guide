package com.jokim.profile;

import org.springframework.stereotype.Service;

@Service
@DevProfile
public class DevGreetingService implements GreetingService {

    @Override
    public String getProfileName() {
        return "dev";
    }
}


