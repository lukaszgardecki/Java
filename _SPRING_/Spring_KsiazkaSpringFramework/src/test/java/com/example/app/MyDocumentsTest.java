package com.example.app;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.java.service.SearchEngine;
import com.example.app.spring.data.DocumentRepository;
import com.example.app.spring.data.TypeDataRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyDocumentsTest {
    private static ApplicationContext context;
    private static SearchEngine engine;
    private static Type webType;

    @BeforeAll
    public static void setup() {
        context = new AnnotationConfigApplicationContext(SpringKsiazkaSpringFrameworkApplication.class);
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(TypeDataRepository.class).findById("webType");
    }

    @Test
    public void testAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertEquals(4, documents.size());
        assertEquals(webType.getName(), documents.get(3).getType().getName());
        assertEquals(webType.getDesc(), documents.get(3).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(3).getType().getExtension());
    }

    @Test
    public void testFindByType() {
        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

}
