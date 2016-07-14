package com.jagadish.spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;







import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jagadish.spring.model.Customer;
import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class); 

	private SessionFactory sessionFactory;


	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
	/*	Customer cust=new Customer();
		cust.setCust_id(p.getProductId());
		cust.setOrders(1);
		cust.setCustomerName("JA");
		
		Order order=new Order();
		List<Product> prodList=new ArrayList<Product>();
		List<Order> orderList=new ArrayList<Order>();
	
		order.setProductList(prodList);
		order.setCustomer(cust);
		order.setOrderId(p.getProductId());
		
		orderList.add(order);
		p.setOrderList(orderList);
		prodList.add(p);
		*/
		 
		//session.saveOrUpdate(cust); 
		session.saveOrUpdate(p);
		//session.saveOrUpdate(order);
		
		 
		 
		
		logger.info("\n\n==Product "+p + "  added succesfully======");
	}


	@Override
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
			Product product =(Product)session.load(Product.class, new Integer(id));
			logger.info("==Product loaded succesfully===product details==="+product);
			
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product>	productList = session.createQuery("from Product").list();
		logger.info("\n\n========ProductDAOIMpl=====getAllProducts size ==="+productList.size());
		
		for(Product p:productList){
			logger.info("Product : "+p);
		}
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order>	productList = session.createQuery("from Order").list();
		logger.info("\n\n========ProductDAOIMpl=====getAllOrders size ==="+productList.size());
		
		for(Order p:productList){
			logger.info("=======Order : "+p);
		}
		return productList;
	}

	@Override
	public void removeProductById(int productId) {

		logger.info("\n\n=====Product  removed REQUEST======");
	
		Session session = this.sessionFactory.getCurrentSession();
		Product product =(Product)session.load(Product.class, new Integer(productId));
		if(product != null)
			session.delete(product);
	
		logger.info("==Product "+product + " removed succesfully======\n\n\n\n");
		
	
	}

	@Override
	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);	
		logger.info("\n\n====Product "+p + " updated succesfully======");
		
	}

}
