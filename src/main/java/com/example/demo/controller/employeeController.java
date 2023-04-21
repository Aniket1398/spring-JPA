package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.Model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class employeeController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return eService.getEmployee();
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id) {
        return " displaying the employee details for the id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return "Saving the employee details to the database " + employee;

    }

    @PutMapping("/employees/{id}")
    public Employee updatEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }

    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam Long id) {
        return "Deleting the Employee details for the id " + id;

    }
}
