package com.example.Spring_Boot_Security_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBootSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJpaApplication.class, args);
	}

}
