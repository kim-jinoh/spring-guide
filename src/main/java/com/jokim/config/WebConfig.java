package com.jokim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 확장으로 WebMvcConfigurer 인터페이스를 구현하여 커스터마이징 가능
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 경로에 대해서 허용
        // https://www.jokim.com 에서 오는 요청만 허용
        registry.addMapping("/**")
            .allowedOrigins("https://www.jokim.com")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}
