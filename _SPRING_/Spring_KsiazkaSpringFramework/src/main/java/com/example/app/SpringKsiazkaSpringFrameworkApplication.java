package com.example.app;

import com.example.app.java.model.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKsiazkaSpringFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKsiazkaSpringFrameworkApplication.class, args);
    }

    @Bean()
    Type getwebType() {
        Type type = new Type();
        type.setName("WEB");
        type.setDesc("Łącze sieciowe");
        type.setExtension(".url");
        return type;
    }

//    @Bean
//    SearchEngineService getSearchEngineService() {
//        SearchEngineService searchEngineService = new SearchEngineService();
//        searchEngineService.setDocumentDAO(getRepository());
//        return searchEngineService;
//    }
//
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

}
