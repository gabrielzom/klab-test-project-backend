package com.example.demoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapi.models.Product;
import com.example.demoapi.services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		service.createProduct(product);
	}
	
	@PutMapping("/{productId}")
	@ResponseStatus(code = HttpStatus.MULTI_STATUS)
	public void updateProduct(
		@PathVariable(value = "productId") Long productId, 
		@RequestBody Product product 
	) {
			service.updateProduct(productId, product);
			
	}
}
