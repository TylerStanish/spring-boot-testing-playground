package com.tylerstanish.springtestingexample.repository;

import com.tylerstanish.springtestingexample.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest{

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  public void whenFindByName_thenReturnEmployee(){
    Employee alex = new Employee("Alex");
    testEntityManager.persist(alex);
    testEntityManager.flush();

    Employee found = employeeRepository.findByName("Alex");

    assertThat(found.getName()).isEqualTo(alex.getName());
  }
}
