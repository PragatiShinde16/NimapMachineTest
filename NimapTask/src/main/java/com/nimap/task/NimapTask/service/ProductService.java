package com.nimap.task.NimapTask.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.task.NimapTask.dao.ProductDao;
import com.nimap.task.NimapTask.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public String addProduct(Product product) {
		String string = dao.addProduct(product);
		if (Objects.isNull(string)) {
			string = "Product is not be added........";
		}
		return string;
	}

	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Product getParticularProduct(int id) {
		Product product = dao.getParticularProduct(id);
		if (Objects.isNull(product)) {
			product = null;
		}
		return product;
	}

	public String updateProduct(Product product, int id) {
		String str = dao.updateProduct(product, id);
		if (Objects.isNull(str)) {
			str = "Product is not Updated.........";
		}
		return str;
	}

	public String deleteProduct(int id) {
		String str = dao.deleteProduct(id);
		if (Objects.isNull(str)) {
			str = "Product is not Deleted.........";
		}
		return str;
	}

}
