package com.example.jpaexercise;

import com.example.jpaexercise.config.AppConfig;
import com.example.jpaexercise.dao.StudentDAO;
import com.example.jpaexercise.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDAO studentDAO = container.getBean(StudentDAO.class);

        Student s1 = new Student();
        s1.setName("Kasia");
        s1.setMobile(1223L);
        s1.setAddress("ul. Katowicka 2/13");

        studentDAO.save(s1);

        List<Student> all = studentDAO.findAll();
        all.forEach(System.out::println);

    }
}
