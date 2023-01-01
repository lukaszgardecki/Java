package com.example.app;

import com.example.app.exception.EmployeeNoLongerWorkingException;
import com.example.app.exception.EmployeeNotFoundException;
import com.example.app.exception.SalaryCalculationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalaryCalculatorServiceTest {

    @Mock
    TaskManagementSystem system;
    SalaryCalculatorService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new SalaryCalculatorService(system);
    }

    @ParameterizedTest(name = "Salary:{0}z³, Tasks:{1}, Salary with bonus:{2}")
    @CsvSource({
            "2000, 0, 2000",
            "2000, 1, 2000",
            "2000, 9, 2000",
            "2000, 10, 2500",
            "2000, 20, 2500",
            "2000, 21, 3000"
    })
    void shouldHaveBonusOrNot(int sal, int finishedTasks, int salWithBonus) {
        Employee employee = new Employee("Jan Kowalski", new BigDecimal(sal));
        when(system.countFinishedTasksForEmployee(employee)).thenReturn(finishedTasks);

        BigDecimal salary = service.calculateSalary(employee);

        assertThat(salary).isEqualTo(BigDecimal.valueOf(salWithBonus));
    }

    @Test
    public void shouldThrowForNoLongerWorkingEmployee() {
        Employee employee = new Employee("Jan Kowalski", BigDecimal.ZERO);

        when(system.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNoLongerWorkingException());

        assertThatThrownBy(() -> service.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNoLongerWorkingException.class)
                .hasMessage("Could not calculate salary. Reason: Employee is no longer hired");
    }

    @Test
    public void shouldThrowForEmployeeNotInDb() {
        Employee employee = new Employee("Jan Kowalski", BigDecimal.ZERO);
        when(system.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNotFoundException());

        assertThatThrownBy(() -> service.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNotFoundException.class)
                .hasMessage("Could not calculate salary. Reason: Employee not found in database");
    }


}