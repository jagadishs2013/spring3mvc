package com.jagadish.spring.service;
import java.util.List;

import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;


public interface ProductService {

	public void addProduct(Product p);
	public void updateProduct(Product p);
	public void removeProduct(int productId);
	public Product getProductById(int productId);
	public List<Product> getProductList();
	public List<Order> getAllOrdersList();
}
