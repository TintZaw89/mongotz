package com.mongodbtz.mongotz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings( CorsRegistry registry) {
                String hostIP = System.getProperty("param1");
                registry.addMapping("/**") // Apply to all endpoints
                        .allowedOrigins("http://"+ hostIP + ":3000","http://localhost:3000", "http://another-allowed-origin.com") // Specify allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true) // Allow credentials (e.g., cookies)
                        .maxAge(3600); // Max age for preflight requests in seconds
            }
        };
    }
}