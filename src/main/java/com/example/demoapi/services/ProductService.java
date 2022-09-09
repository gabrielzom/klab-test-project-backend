package com.example.demoapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapi.models.Product;
import com.example.demoapi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public Optional<Product> getProductById(Long productId) {
		return repository.findById(productId);
	}
	
	public void createProduct(Product product) {
		repository.save(product);
	}
	
	public void updateProduct(Long productId, Product product) {
		Product productToUpdate = this.getProductById(productId).get();
		
		productToUpdate.setName(product.getName());
		productToUpdate.setQuantityInInventory(product.getQuantityInInventory());
		productToUpdate.setQuantityWithDefect(product.getQuantityWithDefect());
		productToUpdate.setImgUrl(product.getImgUrl());
		productToUpdate.setPrice(product.getPrice());
		
		repository.save(productToUpdate);
		
	}
}

