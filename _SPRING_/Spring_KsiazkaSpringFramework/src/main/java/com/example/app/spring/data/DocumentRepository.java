package com.example.app.spring.data;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DocumentRepository implements DocumentDAO {
    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private List<Document> documents = new ArrayList<>();
    private final TypeDataDAO typeRepository;

    public DocumentRepository(TypeDataDAO typeRepository) {

        this.typeRepository = typeRepository;

        Type pdfType = this.typeRepository.findById("pdfType");
        Type noteType = this.typeRepository.findById("noteType");
        Type webType = this.typeRepository.findById("webType");

        Document doc1 = new Document();
        doc1.setName("Szablon książki");
        doc1.setType(pdfType);
        doc1.setLocation("/Users/felipeg/Documents/Random/Szablon ksiazki.pdf");

        Document doc2 = new Document();
        doc2.setName("Przykładowa umowa");
        doc2.setType(pdfType);
        doc2.setLocation("/Users/felipeg/Documents/Contracts/Przykladowa umowa.pdf");

        Document doc3 = new Document();
        doc3.setName("Clustering with RabbitMQ");
        doc3.setType(noteType);
        doc3.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        Document doc4 = new Document();
        doc4.setName("Pro Spring Security Book");
        doc4.setType(webType);
        doc4.setLocation("http://www.apress.com/9781430248187");

        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);
        documents.add(doc4);
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public Document[] getAll() {
        if (log.isDebugEnabled()) {
            log.debug("Początek metody getAll: ");
        }
        Document[] result = documents.toArray(new Document[documents.size()]);

        if (log.isDebugEnabled()) {
            log.debug("Koniec metody getAll: " + result);
        }
        return result;
    }
}
