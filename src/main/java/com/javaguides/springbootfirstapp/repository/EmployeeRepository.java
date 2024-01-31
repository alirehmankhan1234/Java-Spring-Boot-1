package com.javaguides.springbootfirstapp.repository;

import com.javaguides.springbootfirstapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
