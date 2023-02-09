package com.example.app;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.spring.data.DocumentRepository;
import com.example.app.spring.data.TypeDataRepository;
import com.example.app.spring.service.SearchEngineService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringKsiazkaSpringFrameworkApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringKsiazkaSpringFrameworkApplication.class, args);
        TypeDataRepository typeDataRepository = context.getBean(TypeDataRepository.class);
        DocumentRepository documentRepository = context.getBean(DocumentRepository.class);


        System.out.println("Zawartość TypeDataRepository:");
        for (Map.Entry<String, Type> type : typeDataRepository.getTypes().entrySet()) {
            System.out.printf("Klucz: %s, Wartość: %s%n", type.getKey(), type.getValue());
        }

        System.out.println("Zawartość DocumentRepository:");
        documentRepository.getDocuments().forEach(System.out::println);

    }

//    @Bean()
//    Type getWebType() {
//        Type type = new Type();
//        type.setName("WEB");
//        type.setDesc("Łącze sieciowe");
//        type.setExtension(".url");
//        return type;
//    }
//
//    @Bean()
//    Type getNoteType() {
//        Type type = new Type();
//        type.setName("NOTE");
//        type.setDesc("Notatki tekstowe");
//        type.setExtension(".txt");
//        return type;
//    }
//
//    @Bean()
//    Type getPdfType() {
//        Type type = new Type();
//        type.setName("PDF");
//        type.setDesc("Portable Document Format");
//        type.setExtension(".pdf");
//        return type;
//    }
//
//    @Bean
//    Map<String, Type> getTypes() {
//        Map<String, Type> types = new HashMap<>();
//        types.put("pdfType", getPdfType());
//        types.put("webType", getWebType());
//        types.put("noteType", getNoteType());
//        return types;
//    }

//    @Bean
//    SearchEngineService getSearchEngineService() {
//        SearchEngineService searchEngineService = new SearchEngineService();
//        searchEngineService.setDocumentDAO(getRepository());
//        return searchEngineService;
//    }

//    DocumentRepository getRepository() {
//        DocumentRepository repository = new DocumentRepository();
//
//        Document doc1 = new Document();
//        doc1.setName("Szablon książki");
//        doc1.setType(getPdfType());
//        doc1.setLocation("/Users/felipeg/Documents/Random/Szablon ksiazki.pdf");
//        repository.setDoc1(doc1);
//
//        Document doc2 = new Document();
//        doc2.setName("Przykładowa umowa");
//        doc2.setType(getPdfType());
//        doc2.setLocation("/Users/felipeg/Documents/Contracts/Przykladowa umowa.pdf");
//        repository.setDoc2(doc2);
//
//        Document doc3 = new Document();
//        doc3.setName("Clustering with RabbitMQ");
//        doc3.setType(getNoteType());
//        doc3.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
//        repository.setDoc3(doc3);
//
//        Document doc4 = new Document();
//        doc4.setName("Pro Spring Security Book");
//        doc4.setType(getwebType());
//        doc4.setLocation("http://www.apress.com/9781430248187");
//        repository.setDoc4(doc4);
//
//        return repository;
//    }

//    @Bean
//    List<Document> storage() {
//        List<Document> result = new ArrayList<>();
//
//        Type type = new Type();
//        type.setName("PDF");
//        type.setDesc("Portable Document Format");
//        type.setExtension(".pdf");
//
//
//        Document document = new Document();
//        document.setName("Szablon książki");
//        document.setType(type);
//        document.setLocation("/Users/felipeg/Documents/Random/Szablon ksiazki.pdf");
//
//        result.add(document);
//
//        document = new Document();
//        document.setName("Przykładowa umowa");
//        document.setType(type);
//        document.setLocation("/Users/felipeg/Documents/Contracts/Przykladowa umowa.pdf");
//
//        result.add(document);
//
//        type = new Type();
//        type.setName("NOTE");
//        type.setDesc("Notatki tekstowe");
//        type.setExtension(".txt");
//
//        document = new Document();
//        document.setName("Clustering with RabbitMQ");
//        document.setType(type);
//        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
//
//        result.add(document);
//
//        type = new Type();
//        type.setName("WEB");
//        type.setDesc("Łącze sieciowe");
//        type.setExtension(".url");
//
//        document = new Document();
//        document.setName("Pro Spring Security Book");
//        document.setType(type);
//        document.setLocation("http://www.apress.com/9781430248187");
//
//        result.add(document);
//
//        return result;
//    }

}
