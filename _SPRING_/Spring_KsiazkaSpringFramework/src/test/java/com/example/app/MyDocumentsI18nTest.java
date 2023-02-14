package com.example.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;
public class MyDocumentsI18nTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsI18nTest.class);
    private static ApplicationContext context;

    @BeforeAll
    public static void setup() {
        context = new AnnotationConfigApplicationContext(SpringKsiazkaSpringFrameworkApplication.class);
    }

    @Test
    public void testMenu() {
        log.debug("Do przetłumaczenia...");
        String polish = context.getMessage("main.title", null, Locale.of("pl"));
        String spanish = context.getMessage("main.title", null, Locale.of("es"));
        System.out.println("Polski: " + polish);
        System.out.println("Spanish: " + spanish);
    }
}
