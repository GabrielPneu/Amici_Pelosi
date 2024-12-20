/**
 * 
 */
package com.fpt.petstore.repository;

import java.util.List;

import com.fpt.petstore.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {

  @Query( "SELECT p FROM Product p WHERE p.code = :code")
  public Product getByCode(@Param("code") String code);

  @Query(value = "Select * from Product where sortName = ?1",nativeQuery = true)
    public Product getbySortName(String sortName);


  public List<Product> findByType(Product.ProductType productType);

  @Query(value = "select * from product", nativeQuery = true)
  Page<Product> listProductbyPage(Pageable pageable);
  @Query(value = "select count(*) from Product", nativeQuery = true)
  Integer countProduct();
  Product findById(long id);
  @Query(value="SELECT * FROM PRODUCT where Upper(name) like UPPER(CONCAT('%',?1,'%'))",nativeQuery = true)
  List<Product> findProductByNamee(String name);
  @Query(value="select * from product where price = ?1",nativeQuery = true)
  List<Product> findProductbyPrice(long price);
}
