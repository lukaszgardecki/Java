package com.example.jpaexercise;

import com.example.jpaexercise.dao.StudentDAO;
import com.example.jpaexercise.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        Student s1 = new Student();
        s1.setName("Kasia");
        s1.setMobile(1223L);
        s1.setAddress("ul. Katowicka 2/13");

//        studentDAO.save(s1);

        List<Student> all = studentDAO.findAll();
        all.forEach(System.out::println);

    }
}
