package com.ty.Rating_app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class Rating_config {
	
	@Bean
	public EntityManager getEManager() {
		return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	}
	
	@Bean
	public EntityTransaction eTransaction() {
		return getEManager().getTransaction();
	}

}