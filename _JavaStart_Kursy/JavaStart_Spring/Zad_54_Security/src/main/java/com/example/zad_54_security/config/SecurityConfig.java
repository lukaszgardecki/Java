package com.example.zad_54_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(2147483642)
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        http.formLogin(form -> form
                .loginPage("/logowanie")
                .loginProcessingUrl("/zaloguj")
                .usernameParameter("user")
                .passwordParameter("pass")
                .permitAll()
        );
        http.csrf().disable();
        return http.build();
    }
}
