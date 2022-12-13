package com.example.zad_54_security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomInMemoryUserDetailsManager extends InMemoryUserDetailsManager {

    public CustomInMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("super").password("{noop}hard").roles("ADMIN").build();
        UserDetails user1 = userBuilder.username("john").password("{noop}johny").roles("USER").build();

        createUser(admin);
        createUser(user1);
    }
}
