package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests -> requests
                        .anyRequest()
                        .authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
//                        .loginProcessingUrl("/niewiem")
//                        .usernameParameter("user")
//                        .passwordParameter("user")
                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/wyloguj")
//                        .logoutSuccessUrl("/byebye")
//                        .permitAll())
                //jeśli csrf jest włączony to tak można ustawić stronę wylogowania
                //wyloguj po wysłaniu żądania GET pod adres /logout
                //po wylogowaniu przekieruj do strony /login?logout
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())
                .csrf().disable()
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("superadmin").password("{noop}hard").roles("ADMIN").build();
//        UserDetails user1 = userBuilder.username("john").password("{noop}asdf1234").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user1);
//    }
}
