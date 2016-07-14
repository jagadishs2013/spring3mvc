package com.jagadish.spring.dao;

import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;

public interface OrderDAO {

	public void addOrderToCart(Order o);
	
	public void updateCart(Order o);
	
	public void addOrderToCart(Product p);
	
}
