package com.dojo.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.product.models.Category;
import com.dojo.product.models.Product;
import com.dojo.product.repositories.CategoryRepository;
import com.dojo.product.repositories.ProductCategoryRepository;
import com.dojo.product.repositories.ProductRepository;

@Service
public class ProductCategoryServices{
	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;
	private ProductCategoryRepository prodCatRepo;
	public ProductCategoryServices(ProductRepository productRepo, CategoryRepository categoryRepo,
			ProductCategoryRepository prodCatRepo) {
		super();
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.prodCatRepo = prodCatRepo;
	}
	
	public Product create(Product newProduct) {
    	return productRepo.save(newProduct);
    	}
	public Category makeCategory(Category newCategory) {
		return categoryRepo.save(newCategory);
	}
	
	public List<Product>getAllProducts(){
		return(List<Product>)productRepo.findAll();
	}
	
	public List<Category>getAllCategories(){
		return (List<Category>)categoryRepo.findAll();
	}
	public Product getProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	public Category getCategory(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	
	
	public Product addCategoryToProduct(Product product, Long categoryId) {
         Category newCategory=categoryRepo.findById(categoryId).get(); 
        List<Category> currentCategories = product.getCategories();
        currentCategories.add(newCategory);
        product.setCategories(currentCategories);
        return productRepo.save(product);
    }
	
	
	public Category addProductToCategory(Category category, Long productId) {
		Product newProduct=productRepo.findById(productId).get(); 
		List<Product> currentProducts = category.getProducts();
		currentProducts.add(newProduct);
		category.setProducts(currentProducts);
		return categoryRepo.save(category);
		
	}
	public List<Category>findCategoryNotBelongingTo(Product product){
		return categoryRepo.findByproductsNotContaining(product);
	}
	public List<Product>findProductNotBelongingTo(Category category){
		return productRepo.findByCategoriesNotContaining(category);
	}
	 


    }
	
	

