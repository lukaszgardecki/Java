package com.example.app.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Poniższe dwa ustawienia umożliwiają wyświetlenie konsoli H2:
        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
                .headers().frameOptions().sameOrigin();


        return http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/").permitAll()
                        // odblokowanie zasobów statycznych (css i zdjęć) dla wszystkich użytkowników
                        .requestMatchers("/img/**", "/styles/**").permitAll()
                        // odblokowanie dostępu do konsoli H2:
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/register", "/confirmation").permitAll()
                        .requestMatchers("/secured", "/change-password").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
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
                        .logoutSuccessUrl("/"))
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("superadmin").password("{noop}hard").roles("ADMIN").build();
//        UserDetails user1 = userBuilder.username("john").password("{noop}asdf1234").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user1);
//    }

    //Drugi sposób odblokowania zasobów statycznych dla wszystkich użytkowników (wersja wyżej z permitAll jest lepsza)
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers("/img/**", "/styles/**");
//    }
}
