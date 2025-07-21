package com.techlab.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Todos los endpoints
                .allowedOrigins("*")  // Permite cualquier origen
                .allowedMethods("*")  // Todos los métodos (GET, POST, etc.)
                .allowedHeaders("*"); // Todos los headers
    }
}
