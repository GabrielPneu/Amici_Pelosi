package com.fpt.petstore.data;

import com.fpt.petstore.entities.Employee;

public class EmployeeData {
  public Employee employee_1 =
          new Employee("Gabriel Pereira Amancio")
                  .withAddress("Rua pipoca doce, 143")
                  .withEmail("gabriel@gmail.com")
                  .withPassword("12345")
                  .withUsername("gabriel.pereira")
                  .withPhone("011965657890");

  public Employee employee_2 =
          new Employee("Rafael Alves Lopes")
                  .withAddress("Rua morango azul, 123")
                  .withEmail("rafael@gmail.com")
                  .withPassword("12345")
                  .withUsername("hothanhbinh")
                  .withPhone("011965657890");

  public Employee[] ALL_EMPLOYEES = {
          employee_1,
          employee_2,
  };
}