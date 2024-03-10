package com.bahadirmemis.n11product.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author bahadirmemis
 */
public interface ProductRepository extends SolrCrudRepository<Product,String> {

  Optional<Product> findById(String id);

  List<Product> findByNameContaining(String name);

  @Query("name:*?0*")
  List<Product> findByNameContaining2(String name);

  List<Product> findByPriceLessThan(Integer price);

  List<Product> findByPriceGreaterThan(Integer price);

  List<Product> findByPriceBetween(Integer price1, Integer price2);

  @Query("expiration_date:[?0 TO *]")
  List<Product> findByExpirationDateAfter(String date);

  @Query("id:*?0* OR name:*?0*")
  List<Product> findByCustom(String searchItem);

  @Query(name = "Product.findByIdOrNameContains")
  List<Product> findByNamed(String searchItem);
}