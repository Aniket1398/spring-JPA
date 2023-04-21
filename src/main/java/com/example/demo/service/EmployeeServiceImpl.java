package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> list = new ArrayList<>();

    static {
        Employee e = new Employee();
        e.setName("Aniket");
        e.setLocation("BLR");
        e.setDepartment("CSE");
        e.setEmail("xyz@gmail.com");
        e.setAge(24L);
        list.add(e);
    }

    @Override
    public List<Employee> getEmployee() {
        return list;
    }
}
