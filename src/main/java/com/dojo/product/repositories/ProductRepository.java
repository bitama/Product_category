package com.dojo.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.product.models.Category;
import com.dojo.product.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product>findAll();
	List<Product>findByCategoriesNotContaining(Category category);
}
