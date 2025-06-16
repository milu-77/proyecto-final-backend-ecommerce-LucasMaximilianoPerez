package com.techlab.ecommerce.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/**","/login", "/css/**", "/js/**").permitAll() //.hasRole("ADMIN")
                          // Permite acceso a H2 Console sin autenticación
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(PathRequest.toH2Console()) // Desactiva CSRF para H2
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable) // Necesario para H2 Console
                )
                .formLogin(form -> form
                        .loginPage("/login")        // Página de login personalizada
                        .defaultSuccessUrl("/login-success")  // Ruta tras login exitoso
                        .failureUrl("/login?error=true")   // Ruta si hay error
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );

        return http.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
