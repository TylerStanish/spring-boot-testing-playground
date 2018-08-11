package com.tylerstanish.springtestingexample.service;

import com.tylerstanish.springtestingexample.model.Employee;
import com.tylerstanish.springtestingexample.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest{

  @TestConfiguration
  static class EmployeeServiceTestContextConfiguration{
    @Bean
    public EmployeeService employeeService(){
      return new EmployeeService();
    }
  }

  @Autowired
  private EmployeeService employeeService;

  @MockBean
  private EmployeeRepository employeeRepository;

  @Before
  public void setUp(){
    Employee alex = new Employee("Alex");
    Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
  }

  @Test
  public void whenValidName_thenEmployeeShouldBeFound(){
    String name = "Alex";

    Employee found = employeeRepository.findByName(name);

    assertThat(found.getName()).isEqualTo(name);
  }
}
