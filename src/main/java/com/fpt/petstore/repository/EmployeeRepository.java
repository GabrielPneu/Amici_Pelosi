/**
 * 
 */
package com.fpt.petstore.repository;

import com.fpt.petstore.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
  @Query(
      "SELECT e FROM Employee e WHERE e.username = :username")
  public Employee getByUsername(@Param("username") String username);
  
  Boolean existsByUsername(String username);
  
  Boolean existsByEmail(String email);
}
