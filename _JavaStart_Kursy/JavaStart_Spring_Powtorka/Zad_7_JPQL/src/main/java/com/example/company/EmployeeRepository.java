package com.example.company;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

//    @Query(value = "SELECT e FROM Employee e WHERE e.lastName = ?1 AND e.salary = ?2")
    @Query(value = "SELECT e FROM Employee e WHERE e.salary > :min  AND e.salary < :max")
    List<Employee> findBySalaryInRange(double min, double max);

    @Query("UPDATE Employee e SET e.salary = e.salary + 100")
    @Modifying
    @Transactional
    void giveRiseToAll();

    @Query(value = "SELECT * FROM employee WHERE salary > 10000", nativeQuery = true)
    List<Employee> findRichEmployees();
}
