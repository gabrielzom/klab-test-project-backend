package com.example.demoapi.models;

import javax.persistence.*;

@Entity @Table(name = "Tab_Demo_Api_Products")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false)
	private Long quantityInInventory;
	
	@Column(nullable = false)
	private Long quantityWithDefect;
	
	@Column(nullable = false, length = 500)
	private String imgUrl;
	
	@Column(nullable = true)
	private Double price;
	
	public Product () {}
	
	public Product (Product product) {
		this.name = product.getName();
		this.quantityInInventory = product.getQuantityInInventory();
		this.quantityWithDefect = product.getQuantityWithDefect();
		this.imgUrl = product.getImgUrl();
		this.price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantityInInventory() {
		return quantityInInventory;
	}

	public void setQuantityInInventory(Long quantityInInventory) {
		this.quantityInInventory = quantityInInventory;
	}

	public Long getQuantityWithDefect() {
		return quantityWithDefect;
	}

	public void setQuantityWithDefect(Long quantityWithDefect) {
		this.quantityWithDefect = quantityWithDefect;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}