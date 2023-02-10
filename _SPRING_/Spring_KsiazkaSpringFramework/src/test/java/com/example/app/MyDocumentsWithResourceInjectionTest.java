package com.example.app;

import com.example.app.spring.views.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyDocumentsWithResourceInjectionTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private static ApplicationContext context;

    @BeforeAll
    public static void setup() {
        context = new AnnotationConfigApplicationContext(SpringKsiazkaSpringFrameworkApplication.class);
    }

    @Test
    public void testMenu() {
        log.debug("Wywołanie menu jako wstrzyknięcia zasobu:");
        Menu menu = context.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu();
    }
}
