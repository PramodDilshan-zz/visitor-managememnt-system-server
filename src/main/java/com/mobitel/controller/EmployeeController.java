package com.mobitel.controller;

import com.mobitel.model.Employee;
import com.mobitel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pramod-dilshan on 1/7/18.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST,path = "/save")
    public Employee saveEmployee(Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find-all")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public ResponseEntity<Boolean> Login(@RequestParam String username, @RequestParam String password){
        boolean result = this.employeeService.isAuthorized(username, password);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
}
