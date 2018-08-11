package com.tylerstanish.springtestingexample.repository;

import com.tylerstanish.springtestingexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

  public Employee findByName(String name);
}
