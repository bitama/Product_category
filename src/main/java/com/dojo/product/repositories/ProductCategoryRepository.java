package com.dojo.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.product.models.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
    List<ProductCategory>findAll();
}
