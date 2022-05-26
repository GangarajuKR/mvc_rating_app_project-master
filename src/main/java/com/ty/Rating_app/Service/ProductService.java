package com.ty.Rating_app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Rating_app.Exception.NoIdFoundException;
import com.ty.Rating_app.dao.ProductDao;
import com.ty.Rating_app.dto.Product;
import com.ty.Rating_app.dto.User;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public Product saveProduct(Product product) {
		Product p = dao.saveProduct(product);
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}

	public Product updateProuct(int id, Product product) {
		Product p = dao.updateProduct(id, product);
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}

	public Product deleteProduct(int id) {
		Product p = dao.deleteProductById(id);
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}

	public List<Product> getallByProductsUser() {
		List<Product> p = dao.listProducts();
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}
	
	static int count=1;
	static double d1;
	public Product rating(Product product) {
		Product s = dao.getProductById(product.getId());
		
		double oldrating = s.getRating();
		double newrating = product.getRating();
		
		if(count==1) {
			d1=oldrating;
		}
		d1+=newrating;
		double d2 = d1/(++count);
		product.setRating(d2);
		Product p = dao.givingRating(product);
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}
	
	public Product getProduct(int id) {
		Product p = dao.getProductById(id);
		if (p == null) {
			throw new NoIdFoundException();
		}
		return p;
	}
	
}
