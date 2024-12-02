/**
 *
 */
package com.fpt.petstore.services;

import com.fpt.petstore.core.dao.DAO;
import com.fpt.petstore.core.dao.query.Filter;
import com.fpt.petstore.core.dao.query.SimpleFilter;
import com.fpt.petstore.core.dao.query.SqlQueryParams;
import com.fpt.petstore.core.dao.query.SqlQueryTemplate;
import com.fpt.petstore.repository.FoodRepository;
import com.fpt.petstore.entities.Food;
import com.fpt.petstore.entities.Food.FoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class FoodLogic extends DAO {

  @Autowired
  FoodRepository repo;

  public Food saveFood(Food food) {
    return repo.save(food);
  }

  public Food getFoodByCode(String code) {
    return repo.getByCode(code);
  }

  public List<Food> findFoodByType(FoodType foodType) {
    return repo.findByType(foodType);
  }

  public List<Food> findAllFoods() {
    return (List<Food>) repo.findAll();
  }

  public Food getFoodbySortName(String sortName){
    return repo.getbySortName(sortName);
  }
  public boolean deleteFoodById(Long id) {
    repo.deleteById(id);
    return true;
  }

  public boolean deleteFoods(List<Food> foods) {
    for (Food sel : foods) {
      deleteFoodById(sel.getId());
    }
    return true;
  }

  public Integer countFood(){
    return repo.countFood();
  }

  SqlQueryTemplate createFoodQuery(SqlQueryParams params) {
    SqlQueryTemplate.EntityTable TABLE = new SqlQueryTemplate.EntityTable(Food.class, "m");
    SqlQueryTemplate query = new SqlQueryTemplate("petstore", "food", "Search foods").
      SELECT_FROM(TABLE).
      FILTER(new SimpleFilter("search", Filter.FilterType.STRING_LIKE, "m.code LIKE :search")).
      ORDERBY(new String[] { "code" }, "code", "DESC");
    if (params != null) {
      query.mergeValue(params);
    }
    return query;
  }

  public List<Map<String, Object>> searchFoods(SqlQueryParams params) {
    SqlQueryTemplate query = createFoodQuery(params);
    return query(query).getMapRecords();
  }

  public Page<Food> listFoodbyPage(Pageable pageable) {
    return repo.listFoodbyPage(pageable);
  }
  public Food findbyId(long id){
    return repo.findById(id);
  }
  public List<Food> findFoodbyName(String name){
    return  repo.findfoodByName(name);
  }
  public List<Food> findFoodbyPrice(long price){
    return repo.findByPrice(price);
  }

}
