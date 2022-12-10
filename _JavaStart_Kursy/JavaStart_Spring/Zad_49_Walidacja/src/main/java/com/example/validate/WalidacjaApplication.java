package com.example.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WalidacjaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WalidacjaApplication.class, args);
        PersonService service = context.getBean(PersonService.class);
        Person p1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        System.out.println("Adding " + p1);
        service.addPerson(p1);

        Person p2 = new Person("Anna", null, "mail@mail.com", 22);
        System.out.println("Adding " + p2);
        service.addPerson(p2);

        Person p3 = new Person("Piotr", "Ogórek", "złyEmail", 24);
        System.out.println("Adding " + p3);
        service.addPerson(p3);

        Person p4 = new Person("Zenek", "Martyniuk", "zeno@com.pl", 0);
        System.out.println("Adding " + p4);
        service.addPerson(p4);


        System.out.println(service);
    }

}
