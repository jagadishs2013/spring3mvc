package com.jagadish.spring.dao;

import java.util.List;

import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;

public interface ProductDAO {
	
	public void addProduct(Product p);
	public void removeProductById(int id);
	public Product getProductById(int id);
	public void updateProduct(Product p);
	public List<Product> getAllProducts();
	public List<Order> getAllOrders();
	

}
