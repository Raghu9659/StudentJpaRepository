package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	// ADD PRODUCT
	public Product addProduct(ProductDto dto) {
		
		Product product = new Product();
		
		product.setProductName(dto.getProductName());
		product.setCategory(dto.getCategory());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		
		return repository.save(product);
		
		
	}

	
	//GET ALL
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	//GET BY ID
	public Product getProductById(Integer id) {
		
		return repository.findById(id).orElse(null);
	}
	
	// DELETE
	public String deleteProduct(Integer id) {
		
		repository.deleteById(id);
		
		return "Product Deleted";
	}
	
	// FULL UPDATE
	public Product updateProduct(Integer id, ProductDto dto) {
		
		Product product = repository.findById(id).orElse(null);
		
		if (product != null) {
			
			product.setProductName(dto.getProductName());
			product.setCategory(dto.getCategory());
			product.setPrice(dto.getPrice());
			product.setQuantity(dto.getQuantity());
			
			return repository.save(product);
		}
		
		return null;
	}
	
	//PARTIAL UPDATE
	public Product partialUpdate(Integer id, ProductDto dto) {
		
		Product product = repository.findById(id).orElse(null);
		
		if(product != null) {
			
			if (dto.getProductName() != null) {
				product.setProductName(dto.getProductName());
				
			}
			
			if(dto.getCategory() != null) {
				product.setCategory(dto.getCategory());
				
			}
			
			if(dto.getPrice() != 0) {
				product.setPrice(dto.getPrice());
			}
			  if (dto.getQuantity() != 0) {
	                product.setQuantity(dto.getQuantity());
	            }
			  return repository.save(product);
		}
		
		return null;
	}
	
	//FIND BY PRODUCT NAME
	public List<Product> getByProductName(String productName) {
		
		return repository.findByProductName(productName);
	}
	
	//PRICE GREATER THAN
	public List<Product> getPriceGreaterThan(double price){
		return repository.findByPriceGreaterThan(price);
	}
	
	// Price Less Than
    public List<Product> getPriceLessThan(double price) {
        return repository.findByPriceLessThan(price);
    }
    
    // Product Name Contains
    public List<Product> getByKeyword(String keyword) {
        return repository.findByProductNameContaining(keyword);
    }
    
 // Quantity Greater Than
    public List<Product> getQuantityGreaterThan(int quantity) {
        return repository.findByQuantityGreaterThan(quantity);
    }
    
    // Category And Price Less Than
    public List<Product> getByCategoryAndPrice(String category, double price) {
        return repository.findByCategoryAndPriceLessThan(category, price);
    }
    
   

    // Price Between
    public List<Product> getPriceBetween(double start, double end) {
        return repository.findByPriceBetween(start, end);
    }
    // Name Starting With
    public List<Product> getNameStartingWith(String name) {
        return repository.findByProductNameStartingWith(name);
    }

    // Name Ending With
    public List<Product> getNameEndingWith(String name) {
        return repository.findByProductNameEndingWith(name);
    }

    // Exists By Product Name
    public boolean existsByProductName(String productName) {
        return repository.existsByProductName(productName);
    }

    
    
    
    
}
