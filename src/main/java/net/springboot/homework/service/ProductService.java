package net.springboot.homework.service;

import java.util.List;

import net.springboot.homework.entities.Product;


public interface ProductService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductById(long id);
	void deleteProductById(long id);
}
