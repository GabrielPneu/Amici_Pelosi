package com.fpt.petstore.repository;

import java.util.List;

import com.fpt.petstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
  
  @Query(
      "SELECT o FROM Order o WHERE o.code = :code")
  public Order getByCode(@Param("code") String code);
  
  @Query("SELECT o FROM Order o WHERE o.customer.username = :username")
  public List<Order> findOrdersByCustomer(@Param("username") String username);
  
  @Query("SELECT o FROM Order o WHERE o.employee.username = :username")
  public List<Order> findOrdersByEmployee(@Param("username") String username);

  @Query(value = "select * from Orders where customerId= ?1",nativeQuery = true)
  public List<Order> listOrderbyId(Long id);
}
