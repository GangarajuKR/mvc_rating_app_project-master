package com.ty.Rating_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.Rating_app.Service.ProductService;
import com.ty.Rating_app.Service.UserService;
import com.ty.Rating_app.dto.Product;
import com.ty.Rating_app.dto.User;

@RestController
public class CostumerController {
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	UserService uservice;
	
	@RequestMapping("customer")
	public ModelAndView allproducts(){
		List<Product> list = pservice.getallByProductsUser();
		ModelAndView view = new ModelAndView();
		view.addObject("products", list);
		view.setViewName("costumer.jsp");
		return view;
	}
	
	@RequestMapping("giverating")
	public ModelAndView getrate(Product product) {
		ModelAndView view = new ModelAndView();
		view.addObject("product", product);
		view.setViewName("rating.jsp");
		return view;
	}
	
	@RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
	public ModelAndView rate(@RequestParam int proId) {
		ModelAndView view = new ModelAndView();
		Product product = pservice.getProduct(proId);
		view.addObject("product", product);
		view.setViewName("rating.jsp");
		return view;
	}

	@RequestMapping("rating")
	public ModelAndView rating(@ModelAttribute Product product) {
		ModelAndView view = new  ModelAndView();
		System.out.println(product.getId());
		Product struture = pservice.rating(product);
		view.addObject("product", product);
		view.setViewName("customer.jsp");
		return view;
	}
}
