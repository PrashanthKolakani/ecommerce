package com.pk;

import java.util.Map;
import java.util.Scanner;

public class Admin extends User {

	public void addProduct(Map<String, Product> products, Scanner sc) {
		System.out.println("Enter the product name: ");
		String name = sc.next();
		System.out.println("Enter the product id: ");
		String productId = sc.next();
		sc.nextLine();
		System.out.println("Enter the description: ");
		String description = sc.nextLine();
		System.out.println("Enter the price: ");
		float price = getValidInput(sc);
		sc.nextLine();

		Product product = new Product(name, productId, description, price);
		products.put(productId, product);

		System.out.println("Product added successfully! \n");

	}

	public void updateProduct(Map<String, Product> products, Scanner sc) {
		super.displayProducts(products);

		System.out.println("Enter the product id of the product to be updated: ");
		String productId = sc.next();
		if(products.containsKey(productId)) {
			System.out.println("Enter the updated product name: ");
			String name = sc.next();
			sc.nextLine();
			System.out.println("Enter the description: ");
			String description = sc.nextLine();
			System.out.println("Enter the price: ");
			float price = getValidInput(sc);
			sc.nextLine();

			Product product = new Product(name, productId, description, price);
			products.put(productId, product);

			System.out.println("Product updated successfully! \n");
		}else {
			System.out.println("Product with " + productId  + " doesn't exist. \n");
		}

	}

	public void deleteProduct(Map<String, Product> products, Scanner sc) {
		super.displayProducts(products);
		
		System.out.println("Enter the product id of the product to be deleted: ");
		String productId = sc.next();
		if(products.containsKey(productId)) {
			products.remove(productId);
			System.out.println("Product deleted successfully! \n");
		}else {
			System.out.println("Product with " + productId  + " doesn't exist. \n");
		}

	}

	private static float getValidInput(Scanner sc) {
		float price = 0;
		try {
			price = sc.nextFloat();
		} catch (Exception e) {
			price = -1;
		}
		return price;
	}

}
