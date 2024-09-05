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

import com.nimap.task.NimapTask.entity.Category;
import com.nimap.task.NimapTask.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	CategoryService service;
	
//	Create api for insert category
	
	@PostMapping("addcategory")
	public String addCategory(@RequestBody Category category) {
		String str = service.addCategory(category);
		return str;
	}
	
//	Create api to get all category
	
	@GetMapping("allcategory")
	public List<Category> getAllCategory() {
		List<Category> list = service.getAllCategory();
		return list;
	}
	
//	Create api to get perticular category by id
	
	@GetMapping("perticularRecord/{c_id}")
	public Category getParticularCategory(@PathVariable int c_id) {
		Category category = service.getParticularCategory(c_id);
		return category;
	}
	
//	Create api for update category
	
	@PutMapping("update/{c_id}")
	public String updateCategory(@RequestBody Category category, @PathVariable int c_id) {
		String str = service.updateCategory(category, c_id);
		return str;
	}
	
//	Create api for delete category
	
	@DeleteMapping("delete/{c_id}")
	public String deleteCategory(@PathVariable int c_id) {
		String string = service.deleteCategory(c_id);
		return string;
	}
	
}
