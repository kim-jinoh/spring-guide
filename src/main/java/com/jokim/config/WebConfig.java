package com.jokim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 확장으로 WebMvcConfigurer 인터페이스를 구현하여 커스터마이징 가능
}
