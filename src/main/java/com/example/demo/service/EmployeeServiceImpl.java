package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployee() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {

        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }

        throw new RuntimeException("Employee is not found for the id " + id);

    }

    @Override
    public void deleteEmployee(Long id) {

        eRepository.deleteById(id);
    }

    @Override
    public Employee updatEmployee(Employee employee) {
        return eRepository.save(employee);
    }
}
