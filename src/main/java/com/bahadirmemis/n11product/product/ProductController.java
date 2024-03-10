package com.bahadirmemis.n11product.product;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProductById(@PathVariable String id) {
    return productRepository.findById(id);
  }

  @GetMapping("/with-name")
  public List<Product> getProductByNameLike(@RequestParam String name) {
    //return productRepository.findByNameContaining(name);
    return productRepository.findByNameContaining2(name);
  }

  @GetMapping("/price-lt")
  public List<Product> getProductByPriceLt(@RequestParam Integer price) {
    return productRepository.findByPriceLessThan(price);
  }

  @GetMapping("/price-gt")
  public List<Product> getProductByPriceGt(@RequestParam Integer price) {
    return productRepository.findByPriceGreaterThan(price);
  }

  @GetMapping("/price-between")
  public List<Product> getProductByPriceLt(@RequestParam Integer price1, @RequestParam Integer price2) {
    return productRepository.findByPriceBetween(price1, price2);
  }

  @GetMapping("/exp-date-after")
  public List<Product> getProductByExpDateAfter(@RequestParam String date) {
    return productRepository.findByExpirationDateAfter(date);
  }

  @GetMapping("/custom")
  public List<Product> getProductByCustomQuery(@RequestParam String searchItem) {
    return productRepository.findByCustom(searchItem);
  }

  @GetMapping("/named")
  public List<Product> findByNamed(@RequestParam String searchItem) {
    return productRepository.findByNamed(searchItem);
  }

  @PostMapping
  public Product save(@RequestBody Product product) {
    return productRepository.save(product);
  }
}
