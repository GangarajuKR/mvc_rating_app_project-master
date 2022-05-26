package com.ty.Rating_app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Rating_app.dto.Product;
import com.ty.Rating_app.dto.User;

@Repository
public class ProductDao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired 
	EntityTransaction transaction;
	
	@Autowired
	UserDao dao;
	
	public Product saveProduct(Product product) {
		//User user = dao.getUserById(id);
//		if(user!=null) {
//			product.setUser(user);
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return product;
//		}
//		return null;
	}
	
	public Product getProductById(int id) {
		Product product = manager.find(Product.class, id);
		if(product !=null) {
			return product;
		}
		return null;
	}
	
	public Product updateProduct(int p_id,Product product) {
		Product p = getProductById(p_id);
		if(p!=null) {
			transaction.begin();
			manager.merge(product);
			transaction.commit();
			return  product;
		}
		return null;
	}
	 
	public Product deleteProductById(int id) {
		Product p = getProductById(id);
		if(p!=null) {
			transaction.begin();
			manager.remove(p);;
			transaction.commit();
			return  p;
		}
		return null;
	}
	
	public List<Product> listProducts(){
		Query query = manager.createQuery("select p from Product p");
		List<Product> products = query.getResultList();
		return products;
	}
	
	public Product givingRating(Product product) {
		Product p = getProductById(product.getId());
		if(p!=null) {
			transaction.begin();
			manager.merge(product);
			transaction.commit();
			return  product;
		}
		return null;
	}
	
	

}