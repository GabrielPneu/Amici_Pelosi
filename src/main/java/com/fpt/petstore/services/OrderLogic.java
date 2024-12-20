package com.fpt.petstore.services;

import com.fpt.petstore.core.dao.DAO;
import com.fpt.petstore.core.dao.query.*;
import com.fpt.petstore.entities.Customer;
import com.fpt.petstore.entities.Employee;
import com.fpt.petstore.entities.Order;
import com.fpt.petstore.entities.OrderItem;
import com.fpt.petstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class OrderLogic extends DAO {

  @Autowired
  OrderRepository repo;

  public Order saveOrder(Order order) {
  	int total = 0;
    List<OrderItem> items = order.getOrderItems();
    if(items != null) {
    	for(OrderItem item: items) {
    	  total += item.getTotal();
      }
    	order.setTotal(total);
    }
    return repo.save(order);
  }

  public Order getOrderByCode(String code) {
    return repo.getByCode(code);
  }

  public List<Order> findAllOrders() {
    return repo.findAll();
  }

  public boolean deleteOrderById(Long id) {
    repo.deleteById(id);
    return true;
  }

  public boolean deleteOrders(List<Order> orders) {
    for (Order sel : orders) {
      deleteOrderById(sel.getId());
    }
    return true;
  }

  public List<Order> findOrdersByCustomer(Customer customer) {
    return repo.findOrdersByCustomer(customer.getUsername());
  }

  public List<Order> findOrdersByEmployee(Employee employee) {
    return repo.findOrdersByEmployee(employee.getUsername());
  }
  public List<Order> listOrderbyId(Long id){
    return repo.listOrderbyId(id);
  }

  SqlQueryTemplate createOrderQuery(SqlQueryParams params) {
    String[] searchFields = {"o.code", "o.label", "c.username", "c.fullName", "e.username", "e.fullName" };
    SqlQueryTemplate.EntityTable TABLE = new SqlQueryTemplate.EntityTable(Order.class, "o");
    SqlQueryTemplate query = new SqlQueryTemplate("petstore", "Order", "Search Orders").
      SELECT_FROM(TABLE).
      SELECT(
        new SqlQueryTemplate.Field("c.username", "customerUsername"),
        new SqlQueryTemplate.Field("c.fullName",   "customerFullName"),
        new SqlQueryTemplate.Field("e.username", "employeeUsername"),
        new SqlQueryTemplate.Field("e.fullName",   "employeeFullName")).
      JOIN(new SqlQueryTemplate.Join("LEFT JOIN", Customer.class, "c").ON("c.id = o.customerId")).
      JOIN(new SqlQueryTemplate.Join("LEFT JOIN", Employee.class, "e").ON("e.id = o.employeeId")).
      FILTER(
        new SimpleFilter("search", Filter.FilterType.STRING_LIKE, searchFields).withCaseSensitive(false),
        new OptionFilter("o", "state", Filter.FilterType.STRING, Order.State.values(), true),
        new RangeFilter("createTime", Filter.FilterType.DATE),
        new RangeFilter("transactionDate", Filter.FilterType.DATE)).
      ORDERBY(new String[] { "code" }, "code", "DESC");
    if (params != null) {
      if(params.hasParamValue("employeeUsername")) {
        query.FILTER(params.getParam("employeeUsername").format("e.username = '%s'"));
      }
      query.mergeValue(params);
    }
    return query;
  }

  public List<Map<String, Object>> searchOrders(SqlQueryParams params) {
    SqlQueryTemplate query = createOrderQuery(params);
    return query(query).getMapRecords();
  }
}
