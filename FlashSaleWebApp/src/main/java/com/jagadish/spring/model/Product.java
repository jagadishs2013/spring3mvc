package com.jagadish.spring.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementations
 * 
 * @author jsail
 *
 */
//@MappedSuperclass
@Entity
@Table(name="PRODUCT")
public class Product  implements java.io.Serializable {

	private static final long serialVersionUID = 1342750709707490893L;

	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	
	@Column(name = "PRODUCT_NAME", nullable = false,length = 50)
	private String productName;
	
	
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	private String price;
	
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="productList",fetch=FetchType.EAGER)
	private List<Order> orderList;


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", orderList=" + orderList
				+ "]";
	}


	
	
	

	
}
