package com.example.zad_54_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());

        http.formLogin(form -> form
                .loginPage("/login")
                //domyślnie pole formularza z nazwą użytkownika musi mieć nazwę ("name") 'username'
                //możemy to zmienić tutaj podając inną nazwę
//                .usernameParameter("user")
                //domyślnie pole formularza z hasłem musi mieć nazwę ("name") 'password'
                //możemy to zmienić tutaj podając inną nazwę
//                .passwordParameter("pass")
                //określamy, że do tej strony może mieć dostęp każdy:
                .permitAll());


        http.logout(log -> log
                // możemy okreslić adres wylogowywania (domyślnie jest /logout)
//                .logoutUrl("/wyloguj")
                //możemy okreslić adres pod który zostaniemy przekierowani po wylogowaniu się
                .logoutSuccessUrl("/byebye")
                //określamy, że do tej strony może mieć dostęp każdy:
                .permitAll()
        );

        // ze względu że ochrona csrf jest wyłączona, to nie będziemy mieli formularza wylogowywania się,
        // tylko wylogowanie nastąpi po przejściu pod adres /logout
        http.csrf().disable();
        return http.build();
    }


    // W celu przechowywania kont użytkowników w bazie danych należy utworzyć osobną klasę
    // rozszerzającą InMemoryUserDetailsManager.
    // Konta użytkowników możemy przechowywać w pamięci, w mapie tworząc poniższego Beana.
//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("super").password("{noop}hard").roles("ADMIN").build();
//        UserDetails user1 = userBuilder.username("john").password("{noop}johny").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user1);
//    }
}
