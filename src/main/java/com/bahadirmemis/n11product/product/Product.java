package com.bahadirmemis.n11product.product;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author bahadirmemis
 */
@SolrDocument(solrCoreName = "n11_products")
public class Product {

  @Id
  @Indexed(name = "id", type = "string")
  private String id;

  @Indexed(name = "name", type = "string")
  private String name;

  @Indexed(name = "price", type = "pint")
  private Integer price;

  @Indexed(name = "stock_count", type = "pint")
  private Integer stockCount;

  @Indexed(name = "expiration_date", type = "pdate")
  private String expirationDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getStockCount() {
    return stockCount;
  }

  public void setStockCount(Integer stockCount) {
    this.stockCount = stockCount;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }
}
