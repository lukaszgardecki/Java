package com.example.spring_security_jwt_2;

import com.example.spring_security_jwt_2.auth.AuthenticationService;
import com.example.spring_security_jwt_2.auth.RegisterRequest;
import com.example.spring_security_jwt_2.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityJwt2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwt2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {
            RegisterRequest admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@gmail.com")
                    .password("adminpass")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getToken());

            RegisterRequest manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@gmail.com")
                    .password("managerpass")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getToken());
        };
    }

}
