package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeRequest.EmployeeRequest;
import com.example.demo.controller.Model.Department;
import com.example.demo.controller.Model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
public class employeeController {

    @Autowired
    private EmployeeService eService;

    @Autowired
    private DepartmentRepository dRepo;

    @Autowired
    private EmployeeRepository eRepo;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(eService.getEmployee(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
        Employee employee = new Employee(eRequest);
        employee = eRepo.save(employee);

        for (String s : eRequest.getDepartment()) {
            Department d = new Department();
            d.setName(s);
            d.setEmployee(employee);

            dRepo.save(d);
        }
        return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updatEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    // @GetMapping("/employees/filter/{name}")
    // public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable
    // String name) {
    // return new ResponseEntity<List<Employee>>(eRepo.findByDepartment(name),
    // HttpStatus.OK);

    // return new
    // ResponseEntity<List<Employee>>(eRepo.getEmployeesByDepartmentName(name),
    // HttpStatus.OK);
    // }
}
