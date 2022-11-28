package com.mojastrona.company;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByLastNameAndSalaryGreaterThanEqualOrderBySalaryDesc(String lastName, double salary);

    //W SQL możemy zapisać wszystko z wielkich liter, natomiast w JPQL znaczenie ma wielkość liter.

    //Przykłady:
    // SQL --->  SELECT * FROM EMPLOYEE
    // JPQL -->  SELECT e FROM Employee e

    // SQL --->  SELECT LAST_NAME FROM EMPLOYEE
    // JPQL -->  SELECT e.lastName FROM Employee e

    // SQL --->  SELECT * FROM EMPLOYEE WHERE SALARY > 3000
    // JPQL -->  SELECT e FROM Employee WHERE e.salary > 3000

    // SQL --->  SELECT * FROM EMPLOYEE WHERE LAST_NAME = 'Kowalski' AND SALARY > 3000
    // JPQL -->  SELECT e FROM Employee WHERE e.lastName = 'Kowalski' AND e.salary > 3000

    // SQL --->  UPDATE Employee SET SALARY
    // JPQL -->  UPDATE Employee e SET e.salary = e.salary + 100

    // SQL --->  DELETE FROM Employee WHERE id = 5
    // JPQL -->  DELETE FROM Employee e WHERE e.id = 5

    @Query("SELECT e FROM Employee e where e.salary > 10000")
    List<Employee> findRichEmployees();

    @Query("UPDATE Employee e SET e.salary = e.salary + 100")
    @Modifying
    @Transactional
    void giveRiseToAll();

    @Query("SELECT e FROM Employee e WHERE e.salary > :min AND e.salary < :max")
    List<Employee> findBySalaryInRange(double min, double max);
}
