package com.jagadish.spring.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2455579623328575465L;
	private long cust_id;
	private String customerName;
	
	/**
	 * @return the cust_id
	 */
	@Id
	@Column(name="CUST_ID",nullable=false)
	@GeneratedValue
	public long getCust_id() {
		return cust_id;
	}
	/**
	 * @param cust_id the cust_id to set
	 */
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer",targetEntity=Order.class,
    fetch=FetchType.EAGER)
    private int orders;

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", customerName="
				+ customerName + "]";
	}    


}
