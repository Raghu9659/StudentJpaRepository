package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//Derived query
	
	
	
	List<Product> findByProductName(String productName);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByPriceLessThan(double price);
	
	List<Product> findByProductNameContaining(String keyword);
	
	List<Product> findByQuantityGreaterThan(int quantity);
	
	List<Product> findByCategoryAndPriceLessThan(String category, Double price);
	
	
	
	

	List<Product> findByPriceBetween(double start, double end);
	
	List<Product> findByProductNameStartingWith(String name);
	
	List<Product> findByProductNameEndingWith( String name);
	
	boolean existsByProductName(String productName);
	
	
	
	
	
	
	
	
	
	
	

}
