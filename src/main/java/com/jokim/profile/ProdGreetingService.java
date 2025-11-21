package com.jokim.profile;

import org.springframework.stereotype.Service;

@Service
@ProdProfile
public class ProdGreetingService implements GreetingService {

    @Override
    public String getProfileName() {
        return "prod";
    }
}


