package com.jagadish.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jagadish.spring.model.Customer;
import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;
import com.jagadish.spring.service.OrderService;

@Controller
public class CartController {

	private OrderService orderService;
	private static final Logger logger = LoggerFactory
			.getLogger(CartController.class);

	/**
	 * @param productService
	 *            the productService to set
	 */
	@Autowired(required = true)
	@Qualifier(value = "orderService")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/order/add/{productId}")
	public String addToCart(@PathVariable("productId") int productId,
			@ModelAttribute("product") Product product,
			@ModelAttribute("order") Order order) {
		logger.info("==CartController=====addProduct to Cart ====product="
				+ product);
		Customer cu = new Customer();
		cu.setCustomerName("customer" + (int) (Math.random() * 3) + 1);
		cu.setOrders(1);
		order.setCustomer(cu);
		logger.info("===CartController=====addProducts ====order=" + order);
		this.orderService.addOrder(order);
		return "redirect:/order";
	}

	@RequestMapping(value = "/order/pay/{productId}")
	public String orderPay(@PathVariable("productId") int productId,
			@ModelAttribute("product") Product product,
			@ModelAttribute("order") Order order) {
		logger.info("===CartController=====orderPay ====product=" + product);
		return "redirect:/paymentSuccess";
	}

}
