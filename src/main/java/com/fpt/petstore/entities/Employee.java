package com.fpt.petstore.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidade da tabela de funcionarios
 */

@Entity
@Table(name = "employee"

)
@JsonInclude(Include.NON_NULL)
@Setter @Getter
@NoArgsConstructor
public class Employee extends BaseAccount {

  public Employee(String fullName) {
    this.fullName = fullName;
  }
}
