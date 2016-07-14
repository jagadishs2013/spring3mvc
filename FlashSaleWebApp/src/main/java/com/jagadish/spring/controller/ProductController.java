package com.jagadish.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jagadish.spring.model.Order;
import com.jagadish.spring.model.Product;
import com.jagadish.spring.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;
	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	/**
	 * @param productService
	 *            the productService to set
	 */
	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/")
	public String home(ModelMap map) {
		return "redirect:/products";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		logger.info("===ProductController===== getAllProducts =====");
		List<Product> prodList = this.productService.getProductList();
		List<Order> orderList = this.productService.getAllOrdersList();
		if (prodList.size() > 0) {
			Product product = prodList.get(0);
			model.addAttribute("productName", product.getProductName());
		}

		if (orderList.size() == 10) {
			prodList = new ArrayList<Product>();
		}

		model.addAttribute("productList", prodList);
		model.addAttribute("orderList", orderList);

		return "products";
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrder(Model model) {
		logger.info("===ProductController===== getOrder =====");
		List<Product> prodList = this.productService.getProductList();
		List<Order> orderList = this.productService.getAllOrdersList();

		model.addAttribute("product", new Product());
		model.addAttribute("productList", prodList);
		model.addAttribute("orderList", orderList);

		return "order";
	}

	@RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
	public String payment(Model model) {
		logger.info("===ProductController===== payment =====");
		List<Product> prodList = this.productService.getProductList();
		List<Order> orderList = this.productService.getAllOrdersList();

		model.addAttribute("product", new Product());
		model.addAttribute("productList", prodList);
		model.addAttribute("orderList", orderList);

		return "paymentSuccess";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addUpdateProduct(@ModelAttribute("product") Product product,
			Model model, RedirectAttributes redirectAttributes) {
		logger.info("\n\n\n\n===ProductController===== addUpdateProduct ====="
				+ product);

		if (product.getProductId() == 0) {
			// new product add
			this.productService.addProduct(product);
			model.addAttribute("product", product);
			redirectAttributes.addFlashAttribute("product", product);
		} else {
			// update product
			this.productService.updateProduct(product);
		}
		return "redirect:/products";
	}

	@RequestMapping(value = "/delete/{productId}")
	public String removeProduct(@PathVariable("productId") int productId) {

		logger.info("\n\n\n\n===ProductController===== removeProduct =====");
		// remove product
		this.productService.removeProduct(productId);
		return "redirect:/products";
	}

	@RequestMapping("/edit/{productId}")
	public String editPerson(@PathVariable("productId") int productId,
			Model model) {
		model.addAttribute("product",
				this.productService.getProductById(productId));
		model.addAttribute("productList", this.productService.getProductList());
		return "products";
	}

}
