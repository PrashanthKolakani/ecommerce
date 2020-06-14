package com.pk;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Product> cartItems;
	
	public Cart() {
		
	}
	
	public Cart(ArrayList<Product> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public ArrayList<Product> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<Product> cartItems) {
		this.cartItems = cartItems;
	}

	public void addProduct(Product product) {
		this.cartItems.add(product);
	}

	public void display() {
		
		if(cartItems.isEmpty()) {
			System.out.println("Cart is empty! \n");
			return;
		}
		
		int i = 1;
		for(Product product : cartItems) {
			System.out.println("Cart item Number: " + i++);
			product.display();
		}
		
	}

	public float totalPrice() {
		float total = 0;
		for(Product product : cartItems) {
			total += product.getPrice();
		}
		return total;
	}
	
	
	

}
