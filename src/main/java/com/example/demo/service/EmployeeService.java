package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.Model.Employee;

public interface EmployeeService {
    List<Employee> getEmployee(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updatEmployee(Employee employee);

}
