package com.tylerstanish.springtestingexample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tylerstanish.springtestingexample.model.Employee;
import com.tylerstanish.springtestingexample.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest{

  @Autowired
  private MockMvc mvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  private EmployeeService employeeService;

  private Employee employeeExpectedResult;
  private JacksonTester<List<Employee>> employeeJacksonTester;

  @Before
  public void setUp(){
    JacksonTester.initFields(this, objectMapper);
    employeeExpectedResult = new Employee("Alex");
  }

  @Test
  public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception{
    Employee alex = new Employee("Alex");
    List<Employee> employees = Arrays.asList(alex);

    given(employeeService.getAllEmployees()).willReturn(employees);

    String json = employeeJacksonTester.write(employees).getJson();

    // actually perform the GET here
    this.mvc.perform(get("/api/employees")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().json(json));
  }
}
