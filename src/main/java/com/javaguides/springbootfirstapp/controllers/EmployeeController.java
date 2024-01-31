package com.javaguides.springbootfirstapp.controllers;

import com.javaguides.springbootfirstapp.beans.Student;
import com.javaguides.springbootfirstapp.models.Employee;
import com.javaguides.springbootfirstapp.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/employees")
    public List<Employee> getStudents(){
        return employeeServiceImpl.getAllEmployee();
    }

    @PostMapping("/employee")
    public void addStudent(@RequestBody Employee employee){
        employeeServiceImpl.saveEmployee(employee);
    }


    @GetMapping("employee/query")
    public Optional<Employee> employeeQueryparam(@RequestParam(name="id")  long id){
        return employeeServiceImpl.getEmployeeById(id);
    }

    @PutMapping("/employee")
    public void updateStudent(@RequestParam(name="id")  long id,
                              @RequestBody Employee employee){
        employeeServiceImpl.updateEmployee(employee, id);
    }

    @DeleteMapping("/employee")
    public void deleteStudent(@RequestParam(name="id")  long id){
        employeeServiceImpl.deleteEmployee(id);
    }
}
