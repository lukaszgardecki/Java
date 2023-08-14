package com.example.springdatajpa.student;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstname(String firstname);

    List<Student> findByFirstnameContaining(String name);

    List<Student> findByLastnameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstnameAndLastname(String firstname, String lastname);

    //JPQL
    @Query("SELECT s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddressWithQueryMethod(String emailId);

    //JPQL
    @Query("SELECT s.firstname from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddressWithQueryMethod(String emailId);

    //SQL
    @Query(value = "SELECT * FROM tbl_student WHERE email_address=:emailId", nativeQuery = true)
    Student getStudentByEmailAddressWithNativeQueryMethod( String emailId);

    //SQL
    @Query(value = "SELECT firstname FROM tbl_student WHERE email_address=:emailId", nativeQuery = true)
    String getStudentFirstNameByEmailAddressWithNativeQueryMethod(String emailId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student SET firstname=?1 WHERE email_address=?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstname, String emailId);
}
