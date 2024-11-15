package com.example.SpringSecurity_Facebook_Login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringSecurityFacebookLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFacebookLoginApplication.class, args);
	}

}
