package com.example.app;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.java.service.SearchEngine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    }

    @Test
    public void testAll() {
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        engine = context.getBean(SearchEngine.class);
        documents = engine.listAll();
        assertNotNull(documents);
        assertEquals(4, documents.size());
    }

    @Test
    public void testFindByType() {
        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
    }

    @Test
    public void testListAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertEquals(4, documents.size());
    }
}
