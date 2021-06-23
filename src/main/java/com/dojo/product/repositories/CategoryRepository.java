package com.dojo.product.repositories;

import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.repository.CrudRepository;

import com.dojo.product.models.Category;
import com.dojo.product.models.Product;

public interface CategoryRepository extends CrudRepository<Category,Long> {
  List<Category>findAll();
  List<Category>findByproductsNotContaining(Product product);
}
