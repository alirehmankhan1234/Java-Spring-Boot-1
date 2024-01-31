package com.javaguides.springbootfirstapp.service;

import com.javaguides.springbootfirstapp.models.Employee;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();

    Optional<Employee> getEmployeeById(long id);

    void updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}
