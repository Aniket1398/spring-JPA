package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.controller.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // List<Employee> findByDepartment(String name);

    // @Query("FROM Employee WHERE department.name = :name")
    // List<Employee> getEmployeesByDepartmentName(String name);
}
