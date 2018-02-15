package com.mobitel.service;

import com.mobitel.model.Employee;
import com.mobitel.repositiry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by pramod-dilshan on 1/30/18.
 */
@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findOne(String username) {
        return this.employeeRepository.findOne(username);
    }

    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public boolean validateUser(String username) {
        return this.employeeRepository.exists(username);
    }


    public boolean isAuthorized(Employee employee) {
        String orgPassword = this.employeeRepository.findOne(employee.getUsername()).getPassword();
        Boolean result = orgPassword.equals(employee.getPassword());
        return result;
    }
}
