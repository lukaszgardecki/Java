package com.example.app;

import com.example.app.java.service.Login;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MyDocumentsWithLoginTest {
    private static Logger logger;
    private static ApplicationContext context;
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test123";
    private static final String SUCCESS = "Ten użytkownik ma autoryzację.";
    private static final String FAILURE = "UWAGA! Ten użytkownik nie ma uatoryzacji!";

    @BeforeAll
    public static void setup() {
        context = new AnnotationConfigApplicationContext(SpringKsiazkaSpringFrameworkApplication.class);
        logger = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);
    }

    @Test
    public void testLogin() {
        logger.debug("Test logowania.");

        Login login = context.getBean(Login.class);

        assertNotNull(login);
        if (login.isAutorized(EMAIL, PASS)) {
            System.out.println(SUCCESS);
        } else {
            System.out.println(FAILURE);
        }
    }

}
