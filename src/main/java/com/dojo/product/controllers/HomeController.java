package com.dojo.product.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojo.product.models.Category;
import com.dojo.product.models.Product;
import com.dojo.product.models.ProductCategory;
import com.dojo.product.repositories.ProductRepository;
import com.dojo.product.services.ProductCategoryServices;




@Controller
public class HomeController {
	public ProductCategoryServices productServ;
	
  public HomeController(ProductCategoryServices productServ) {
		super();
		this.productServ = productServ;
	}
@RequestMapping("/")
  public String home(@ModelAttribute("product")Product product) {
	  return "index.jsp";
  }
  @RequestMapping(value="/products/create",method=RequestMethod.POST)
  public String CreateProduct(@Valid @ModelAttribute("product")Product product,BindingResult result){
	  if(result.hasErrors()) {
		  return"index.jsp";
	  }
	  productServ.create(product);
	return"redirect:/viewProduct/"+ product.getId();  
  }
  @RequestMapping("/category")
  public String createCat(@ModelAttribute("category")Category category){
	  return "category.jsp";
  }
  @RequestMapping(value="/categories/create",method=RequestMethod.POST)
  public String CreateCategory(@Valid @ModelAttribute("category")Category category,BindingResult result){
	  if(result.hasErrors()) {
		  return"category.jsp";
	  }
	  productServ.makeCategory(category);
	return"redirect:/viewCategory/" + category.getId(); 
  }

  @GetMapping("/viewProduct/{id}")
  public String showProduct(@PathVariable("id") Long id,Model model) {
 	 Product myProduct = productServ.getProduct(id);
 	 model.addAttribute("thisProduct",myProduct);
 	List<Category> categoriesInProduct = myProduct.getCategories();
 	model.addAttribute("categoriesInProduct", categoriesInProduct);
 	model.addAttribute("allCategories",productServ.findCategoryNotBelongingTo(myProduct));
 	 return "viewProduct.jsp";
}
  @GetMapping("/viewCategory/{id}")
  public String showCategory(@PathVariable("id") Long id,Model model) {
	  Category myCategory = productServ.getCategory(id);
	  model.addAttribute("thisCategory",myCategory);
	  List<Product> productsInCategory = myCategory.getProducts();
	  model.addAttribute("productCategorie", productsInCategory);
	  model.addAttribute("allProducts",productServ.findProductNotBelongingTo(myCategory));
	  return "showCategory.jsp";
  }
  @RequestMapping(value="/viewProduct/{id}/addCategory",method=RequestMethod.POST)
  public String addCategory(@PathVariable("id") Long id,Model model,@RequestParam("category_Id") String category_Id) {
	  Product myProduct = productServ.getProduct(id);
	  Long cid=Long.parseLong(category_Id);
	  productServ.addCategoryToProduct(myProduct, cid);
	  List<Category> categoriesInProduct = myProduct.getCategories();
	  model.addAttribute("categoriesInProduct", categoriesInProduct);
	  model.addAttribute("thisProduct",myProduct);
	  model.addAttribute("allCategories",productServ.findCategoryNotBelongingTo(myProduct));
	  return "viewProduct.jsp";
	  
  }
	  
	  
	  @RequestMapping(value="/viewCategory/{id}/addProduct",method=RequestMethod.POST)
	  public String addProduct(@PathVariable("id") Long id,Model model,@RequestParam("product_Id") String product_Id) {
		  Category myCategory = productServ.getCategory(id);
		  Long pid=Long.parseLong(product_Id);
		  productServ.addProductToCategory(myCategory, pid);
		  List<Product> productsInCategory = myCategory.getProducts();
		  model.addAttribute("productsInCategory", productsInCategory);
		  model.addAttribute("thisCategory",myCategory);
	      model.addAttribute("allProducts",productServ.getAllProducts());
		  model.addAttribute("allProducts",productServ.findProductNotBelongingTo(myCategory));
		  return "showCategory.jsp";
  }
  
  
  
  
}

