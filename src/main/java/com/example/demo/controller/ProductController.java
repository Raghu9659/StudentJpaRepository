package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	//ADD
	@PostMapping
	public Product addProduct(@RequestBody ProductDto dto) {
		
		return service.addProduct(dto);
		
	}
	
	//GET ALL
	@GetMapping
	public List<Product>  getAllProduct() {
		
		return service.getAllProducts();
		
		
	}
	//GET BY ID
	@GetMapping("/{id}")
	public Product getById(@PathVariable Integer id) {
		return service.getProductById(id);
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		
		return service.deleteProduct(id);
		
	}
	
	//FULL UPDATE
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Integer id,
	                             @RequestBody ProductDto dto) {

	    return service.updateProduct(id, dto);
	}
	
	//PARTIAL UPDATE
	@PatchMapping("/{id}")
	public Product partialUpdate(@PathVariable Integer id, @RequestBody ProductDto dto  ) {
		
		return service.partialUpdate(id, dto);
	}
	//CUSTOM API'S
	

	 // Find By Product Name
	
    @GetMapping("/name/{productName}")
    public List<Product> getByProductName(@PathVariable String productName){
    	return service.getByProductName(productName);
    	
	}
    // Price Less Than
    
   
    
 // Price Greater Than
    @GetMapping("/price/greater/{price}")
    public List<Product> getPriceGreaterThan(
            @PathVariable double price) {

        return service.getPriceGreaterThan(price);
        
    }
    @GetMapping("/price/less/{price}")
    public List<Product> getPriceLessThan(
            @PathVariable double price) {

        return service.getPriceLessThan(price);
    }
    
    // Product Name Contains
    @GetMapping("/keyword/{keyword}")
    public List<Product> getByKeyword(@PathVariable String keyword){
    	return service.getByKeyword(keyword);
    }
    
    // Quantity Greater Than
    @GetMapping("/quantity/{quantity}")
    public List<Product> getQuantityGreaterThan(
            @PathVariable int quantity) {

        return service.getQuantityGreaterThan(quantity);
    }
    
    // Category And Price Less Than
    @GetMapping("/category-price")
    public List<Product> getByCategoryAndPrice(
            @RequestParam String category,
            @RequestParam double price) {

        return service.getByCategoryAndPrice(category, price);
    }
   
   
    // Price Between
    @GetMapping("/price-between")
    public List<Product> getPriceBetween(
            @RequestParam double start,
            @RequestParam double end) {

        return service.getPriceBetween(start, end);
    }
    // Name Starting With
    @GetMapping("/start/{name}")
    public List<Product> getNameStartingWith(
            @PathVariable String name) {

        return service.getNameStartingWith(name);
    }
    
    // Name Ending With
    @GetMapping("/end/{name}")
    public List<Product> getNameEndingWith(
            @PathVariable String name) {

        return service.getNameEndingWith(name);
    }
    @GetMapping("/exists/{productName}")
    public boolean existsByProductName(
            @PathVariable String productName) {

        return service.existsByProductName(productName);
    }
    
   



}
