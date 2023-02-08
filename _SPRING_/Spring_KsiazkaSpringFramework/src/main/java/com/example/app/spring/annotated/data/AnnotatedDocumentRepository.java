package com.example.app.spring.annotated.data;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.spring.data.DocumentDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository()
public class AnnotatedDocumentRepository implements DocumentDAO {

    @Override
    public Document[] getAll() {
        return storage();
    }

    private Document[] storage() {
        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");


        Document document = new Document();
        document.setName("Szablon książki");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Szablon ksiazki.pdf");

        result.add(document);

        document = new Document();
        document.setName("Przykładowa umowa");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Contracts/Przykladowa umowa.pdf");

        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Notatki tekstowe");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Łącze sieciowe");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result.toArray(new Document[result.size()]);
    }
}
