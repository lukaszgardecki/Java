package com.example.app;

import com.example.app.java.model.Type;
import com.example.app.java.service.Login;
import com.example.app.spring.data.DocumentRepository;
import com.example.app.spring.data.TypeDataRepository;
import com.example.app.spring.service.LoginService;
import com.example.app.spring.views.Menu;
import org.apache.naming.factory.ResourceFactory;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@SpringBootApplication
public class SpringKsiazkaSpringFrameworkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringKsiazkaSpringFrameworkApplication.class, args);
        TypeDataRepository typeDataRepository = context.getBean(TypeDataRepository.class);
        DocumentRepository documentRepository = context.getBean(DocumentRepository.class);
        Locale.setDefault(new Locale("es"));
        Login login = context.getBean(LoginService.class);
        boolean autorized = login.isAutorized("test@mydocuments.com", "test123");
        System.out.println(autorized);


//        System.out.println("Zawartość TypeDataRepository:");
//        for (Map.Entry<String, Type> type : typeDataRepository.getTypes().entrySet()) {
//            System.out.printf("Klucz: %s, Wartość: %s%n", type.getKey(), type.getValue());
//        }
//
//        System.out.println("Zawartość DocumentRepository:");
//        documentRepository.getDocuments().forEach(System.out::println);

//        new Menu().printMenu();

    }

    @Bean
    ResourceBundle getMes() {
        return ResourceBundle.getBundle("dictionary", new Locale("es"));
    }



}
