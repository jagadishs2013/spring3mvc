package com.jagadish.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jagadish.spring.dao.OrderDAO;
import com.jagadish.spring.dao.ProductDAO;
import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;



	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	@Transactional
	public void addOrder(Order p) {
		this.orderDAO.addOrderToCart(p);	
			
	}

	@Override
	public void updateOrder(Order p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void addOrder(Product p) {
	this.orderDAO.addOrderToCart(p);	
	}


	

}
