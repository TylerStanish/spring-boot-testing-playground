package com.tylerstanish.springtestingexample.controller;

import com.tylerstanish.springtestingexample.model.Employee;
import com.tylerstanish.springtestingexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController{

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping("/employees")
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }
}
