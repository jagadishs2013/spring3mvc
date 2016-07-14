package com.jagadish.spring.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jagadish.spring.model.Customer;
import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;

public class OrderDAOImpl implements OrderDAO {
         	 
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class); 

	private SessionFactory sessionFactory;


	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOrderToCart(Order o) {
		 Session session=this.sessionFactory.getCurrentSession();
		 Customer cust = o.getCustomer();
		 session.save(cust);
		 session.save(o);
		 logger.info("============added to cart successfully==========");
			
	}

	@Override
	public void updateCart(Order o) {
		// TODO Auto-generated method stub
		
	}

	@Override 
	public void addOrderToCart(Product product) {
	/* Order order=new Order();
	 order.setProduct(product);
	*/	 
	 Session session=this.sessionFactory.getCurrentSession();
	 session.saveOrUpdate(product);
	 //session.saveOrUpdate(order);
	 
	 logger.info("============added to cart successfully==========");
	}

}
