package com.nimap.task.NimapTask.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.task.NimapTask.dao.CategoryDao;
import com.nimap.task.NimapTask.entity.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;
	
	public String addCategory(Category category) {
		String msg = dao.addCategory(category);
		if (Objects.isNull(msg)) {
			msg = "Category is not added...........";
		}
		return msg;
	}

	public List<Category> getAllCategory() {
		List<Category> list = dao.getAllCategory();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Category getParticularCategory(int c_id) {
		Category category = dao.getParticularCategory(c_id);
		if (Objects.isNull(category)) {
			category = null;
		}
		return category;
	}

	public String updateCategory(Category category, int c_id) {
		String str = dao.updateCategory(category, c_id);
		if (Objects.isNull(str)) {
			str = "Category is not Updated...........";
		}
		return str;
	}

	public String deleteCategory(int c_id) {
		String str = dao.deleteCategory(c_id);
		if (Objects.isNull(str)) {
			str = "Category is not Deleted.........";
		}
		return str;
	}

}