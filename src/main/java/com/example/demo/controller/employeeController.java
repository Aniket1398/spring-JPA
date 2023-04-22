package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Employee getEmployee(@PathVariable Long id) {
        return eService.getSingleEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return eService.saveEmployee(employee);

    }

    @PutMapping("/employees/{id}")
    public Employee updatEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return eService.saveEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam Long id) {
        eService.deleteEmployee(id);

    }
}
