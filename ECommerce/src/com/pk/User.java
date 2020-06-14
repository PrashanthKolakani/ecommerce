package com.pk;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class User {
	private String name;
	private String userId;
	private String address;
	private String dob;
	private boolean isAdmin;
	private Cart cart;

	public User() {

	}

	public User(String name, String userId, String address, String dob, boolean isAdmin) {
		super();
		this.name = name;
		this.userId = userId;
		this.address = address;
		this.dob = dob;
		this.isAdmin = isAdmin;
		this.cart = new Cart(new ArrayList<Product>());
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void displayProducts(Map<String, Product> products) {
		
		if(products.isEmpty()) {
			System.out.println("No products are available. Please come back later. \n\n");
			return;
		}
		
		int i = 1;
		
		for (Entry<String, Product> entry : products.entrySet()) {
			System.out.println("Product Number: " + i++);
			Product product = entry.getValue();
			product.display();
		}
				
	}

	public void addToCart(Scanner sc, Map<String, Product> products) {
		
		System.out.println("Enter the productId: ");
		String productId = sc.next();
		
		Product product = products.get(productId);
		this.cart.addProduct(product);
		System.out.println("Product added succesfully. \n");
		
	}

	public void displayCart() {
		this.cart.display();		
	}

	public void checkout() {
		System.out.println("Total price: " + this.cart.totalPrice() + "\n");
		this.cart.setCartItems(new ArrayList<Product>());
		return;
	}

}
