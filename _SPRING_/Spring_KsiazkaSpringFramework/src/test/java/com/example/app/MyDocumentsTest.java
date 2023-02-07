package com.example.app;

import com.example.app.model.Document;
import com.example.app.model.Type;
import com.example.app.service.MySearchEngine;
import com.example.app.service.SearchEngine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyDocumentsTest {

    private SearchEngine engine = new MySearchEngine();

    @Test
    public void testFindByType() {
        Type documentType = new Type();
        documentType.setName("WEB");
        documentType.setDesc("Łącze sieciowe");
        documentType.setExtension(".url");

        List<Document> documents = engine.findByType(documentType);
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals(documentType.getName(), documents.get(0).getType().getName());
        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
    }

    @Test
    public void testListAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertEquals(4, documents.size());
    }
}
