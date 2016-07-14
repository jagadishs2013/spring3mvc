package com.jagadish.spring.service;

import java.util.List;

import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;


public interface OrderService {

	public void addOrder(Order o);
	public void updateOrder(Order p);
	public void removeOrder(int id);
	public Order getOrderById(int id);
	public List<Order> getOrderList();
	
	public void addOrder(Product p);
	
}
