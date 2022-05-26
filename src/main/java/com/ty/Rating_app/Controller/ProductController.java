package com.ty.Rating_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.Rating_app.Service.ProductService;
import com.ty.Rating_app.dto.Product;
import com.ty.Rating_app.dto.User;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("getsave")
	public ModelAndView getSave() {
		ModelAndView view = new ModelAndView();
		view.addObject("product", new Product());
		view.setViewName("createProduct.jsp");
		return view;
	}
	
	@RequestMapping("productsave")
	public ModelAndView save(@ModelAttribute Product product) {
		Product struture = service.saveProduct(product);
		ModelAndView view = new ModelAndView();
		view.addObject("Product", struture);
		view.setViewName("costumer.jsp");
		return view;
	}
	
	@RequestMapping("viewallproducts")
	public ModelAndView allproducts(){
		List<Product> list = service.getallByProductsUser();
		ModelAndView view = new ModelAndView();
		view.addObject("products", list);
		view.setViewName("viewproducts.jsp");
		return view;
	}
	
	@RequestMapping("getupdateproduct")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView view = new ModelAndView();
		view.addObject("product", product);
		view.setViewName("updateproduct.jsp");
		return view;
	}
	
	@RequestMapping("updateprod")
	public ModelAndView updateProd(@ModelAttribute Product product) {
		Product struture = service.updateProuct(product.getId(),product);
		ModelAndView view = new ModelAndView();
		view.addObject("Product", struture);
		view.setViewName("viewallproducts");
		return view;
	}
	
	@RequestMapping("getdelete")
	public ModelAndView deleteProduct(@ModelAttribute Product product) {
		ModelAndView view = new ModelAndView();
		Product struture = service.deleteProduct(product.getId());
		view.setViewName("viewallproducts");
		return view;
	}
	

}
