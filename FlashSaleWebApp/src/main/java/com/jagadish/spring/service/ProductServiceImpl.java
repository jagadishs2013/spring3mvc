package com.jagadish.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jagadish.spring.dao.ProductDAO;
import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;

@Service
//@Component("productService")
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;

	/**
	 * @param productDAO the productDAO to set
	 */
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public void addProduct(Product p) {
		this.productDAO.addProduct(p);
	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		this.productDAO.updateProduct(p);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
	this.productDAO.removeProductById(id);	
	}

	@Override
	@Transactional	
	public Product getProductById(int id) {
		return this.productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public List<Product> getProductList() {
		return productDAO.getAllProducts();
	}
	
	@Override
	@Transactional
	public List<Order> getAllOrdersList() {
		return productDAO.getAllOrders();
	}
	
	

}
