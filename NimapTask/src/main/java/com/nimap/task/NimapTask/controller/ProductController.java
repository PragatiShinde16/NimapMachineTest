package com.nimap.task.NimapTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.task.NimapTask.entity.Product;
import com.nimap.task.NimapTask.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ProductController {

	@Autowired
	ProductService service;
	
//	Create api for insert product
	
	@PostMapping("addproduct")
	public String addProduct(@RequestBody Product product) {
		String str = service.addProduct(product);
		return str;
	}
	
//	Create api to get all product
	
	@GetMapping("allproduct")
	public List<Product> getAllProduct() {
		List<Product> list = service.getAllProduct();
		return list;
	}
	
//	Create api to get perticular product by id
	
	@GetMapping("perticularrecordproduct/{id}")
	public Product getParticularProduct(@PathVariable int id) {
		Product product = service.getParticularProduct(id);
		return product;
	}
	
//	Create api for update product
	
	@PutMapping("updateproduct/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable int id) {
		String str = service.updateProduct(product, id);
		return str;
	}
	
//	Create api for delete product
	
	@DeleteMapping("deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		String string = service.deleteProduct(id);
		return string;
	}
}
