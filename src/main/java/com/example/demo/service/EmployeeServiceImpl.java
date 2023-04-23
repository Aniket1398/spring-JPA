package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployee(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
        return eRepository.findAll(pages).getContent();
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

    @Override
    public List<Employee> getEmployeesByName(String Name) {
        return eRepository.findByName(Name);

    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String Name, String location) {
        return eRepository.findByNameAndLocation(Name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return eRepository.findByNameContaining(keyword, sort);

    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return eRepository.getEmployeesByNameOrLocation(name, location);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return eRepository.deleteEmployeeByName(name);
    }
}
