package com.tylerstanish.springtestingexample.service;

import com.tylerstanish.springtestingexample.model.Employee;
import com.tylerstanish.springtestingexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService{

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee getEmployeeByName(String name){
    return employeeRepository.findByName(name);
  }

  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }
}
