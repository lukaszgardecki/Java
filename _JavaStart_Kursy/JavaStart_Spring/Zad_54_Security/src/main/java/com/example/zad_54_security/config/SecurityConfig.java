package com.example.zad_54_security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
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
        http.authorizeHttpRequests(
                requests -> requests
                        // do tych stron mają dostęp wszyscy:
                        .requestMatchers("/", "/register", "/confirmation").permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        //dostęp do zdjęć, czy arkuszy stylów muszą mieć wszyscy (żeby css formatował htmla):
                        .requestMatchers("/img/**", "/styles/**").permitAll()
                        .requestMatchers("/secured", "/change-password").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()


//                        UWAGA MUSI BYĆ ODPOWIEDNIA KOLEJNOŚĆ!

//                        // ten adres jest dostępny dla wszystkich:
//                        .requestMatchers("/").permitAll() //nie wymagamy uwierzytelnienia
//                        // pod adres rozpoczynający się od "/admin" mogą przejść tylko administratorzy:
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        //zabezpieczenie panelu użytkownika (można również użyć .hasRole("USER")):
//                        .requestMatchers("/user-panel/**").hasAuthority("ROLE_USER") // to samo co .hasRole tylko trzeba dodać ROLE przed nazwą roli
//                        // jeśli mamy kalkulator który przesyła dane metodą post i chcemy go zabezpieczyć, aby dostep mieli tylko użytkownicy i administartorzy:
//                        .requestMatchers("/calculate").hasAnyRole("USER", "ADMIN")
//                        // na końću dobrze jest dodać anyRequest(), aby zabezpieczyć wszystkie niewymienione wyżej zasoby:
//                        // uthenticated() - MUSI BYĆ ZALOGOWANY!
//                        .anyRequest().authenticated()

        );

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
//        http.csrf().disable();
        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
                .logoutSuccessUrl("/")
        );

        // definiujemy wyjątek, który sprawi, że filtr CSRF dla adrsów pasujących do H2ConsoleRequestMatchera będzie ignorowany
        // po prostu będziemy mogli połączyć się z bazą H2
        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()));

        // Spring Security dodaje do odpowiedzi serwera nagłówek X-FRAME-OPTIONS, który uniemożliwia załadowanie naszej strony w ramach elementu iframe.
//        Nagłówek X-FRAME-OPTIONS może przyjmować jedną z dwóch wartości:

//        DENY - żadna strona nie może osadzać naszej strony w ramce,
//        SAMEORIGIN - tylko strony w ramach tej samej domeny mogą osadzać naszą stronę, czyli np. jeżeli chcemy osadzić stronę abc.pl/foo.html na stronie abc.pl/bar.html, to powinniśmy wykorzystać tę opcję.

        // Spring Security domyślnie dodaje nagłówek X-FRAME-OPTIONS w bardziej restrykcyjnej postaci, czyli DENY,
        // przez co konsola H2 nie może być załadowana w ramkach, nawet w ramach naszej własnej strony.
        // Opcję DENY możemy przestawić na SAMEORIGIN
        // ...i teraz wyświetli się nam kosnola H2:
        http.headers().frameOptions().sameOrigin();


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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
