package com.pk;

public class Product {
	
	private String name;
	private String productId;
	private String description;
	private float price;
	
	public Product() {
		
	}
	
	public Product(String name, String productId, String description, float price) {
		super();
		this.name = name;
		this.productId = productId;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void display() {
		System.out.println("Product Name: " + this.name);
		System.out.println("Id: " + this.productId);
		System.out.println("Description: " + this.description);
		System.out.println("Price: " + this.price + "\n\n");
		
	}
	
	

}
