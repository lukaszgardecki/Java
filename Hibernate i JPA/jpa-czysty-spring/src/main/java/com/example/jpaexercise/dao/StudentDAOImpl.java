package com.example.jpaexercise.dao;

import com.example.jpaexercise.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

//@Repository
//public class StudentDAOImpl {
//
////    @PersistenceContext(unitName = "mysqldb")
//    //Jeżeli dodamy zależność spring-data-jpa i adnotację @EnableJpaRepositories to nie musimy tutaj pisać adnotacji @PersistenceContext
//    private final EntityManager entityManager;
//
//    public StudentDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//
//    @Transactional
//    public void saveStudent(Student student) {
//        entityManager.persist(student);
//        System.out.println("Zapisano...");
//    }
//}
