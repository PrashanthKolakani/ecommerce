package com.pk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	static Map<String, User> users = new HashMap<String, User>();
	static Map<String, Product> products = new HashMap<String, Product>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Ecommerce Application! \n");

		User admin = new User("admin", "admin", "", "", true);
		users.put("admin", admin);
		
		//products.put("apple", new Product("laptop", "apple", "macbook", 55000));
		//users.put("pk", new User("Prashanth", "pk", "Bangalore", "01-01-01", false));

		startApplication();

	}

	private static void startApplication() {
		System.out.println("Please chose from the below menu: ");
		System.out.println("1. SignUp");
		System.out.println("2. Login");
		System.out.println("3. Exit");

		int choice = getValidInput();
		sc.nextLine();

		switch (choice) {
		case 1:
			signUp();
			break;
		case 2:
			login();
			break;
		case 3:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Incorrect choice. \n");
		}
		startApplication();
		return;

	}

	private static int getValidInput() {
		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (Exception e) {
			choice = -1;
		}
		return choice;
	}

	private static void login() {
		System.out.println("Enter the user id: ");
		String userId = sc.next();
		if (users.containsKey(userId)) {
			User user = users.get(userId);
			boolean isAdmin = user.isAdmin();
			if (isAdmin) {
				doAdminWork();
			} else {
				doUserWork(user);
			}
		} else {
			System.out.println("user id does not exist.");
			startApplication();
		}
		return;
	}

	private static void doUserWork(User user) {
		while (true) {
			System.out.println("Please chose from the below menu.");
			System.out.println("1. Display Products");
			System.out.println("2. Add a product to the cart");
			System.out.println("3. Display Cart");
			System.out.println("4. CheckOut");
			System.out.println("5. logout");

			int choice = getValidInput();

			switch (choice) {
			case 1:
				user.displayProducts(products);
				break;
			case 2:
				user.addToCart(sc, products);
				break;
			case 3:
				user.displayCart();
				break;
			case 4:
				user.checkout();
				break;
			case 5:
				startApplication();
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}

	}

	private static void doAdminWork() {
		Admin admin = new Admin();
		while (true) {
			System.out.println("Please chose from the below menu.");
			System.out.println("1. Display Products");
			System.out.println("2. Add a product");
			System.out.println("3. Update a product");
			System.out.println("4. Delete a product");
			System.out.println("5. logut");

			int choice = getValidInput();

			switch (choice) {
			case 1:
				admin.displayProducts(products);
				break;
			case 2:
				admin.addProduct(products, sc);
				break;
			case 3:
				admin.updateProduct(products, sc);
				break;
			case 4:
				admin.deleteProduct(products, sc);
				break;
			case 5:
				startApplication();
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}

	}

	private static void signUp() {
		System.out.println("Enter the name: ");
		String name = sc.next();
		System.out.println("Enter the user id: ");
		String userId = sc.next();
		sc.nextLine();
		System.out.println("Enter the address: ");
		String address = sc.nextLine();
		System.out.println("Enter the date of birth: ");
		String dob = sc.next();
		if (users.containsKey(userId)) {
			System.out.println("User Id already exist. \n");
			return;
		}
		User user = new User(name, userId, address, dob, false);
		users.put(userId, user);
		System.out.println("New user " + userId + " successfully created. \n");
	}

}
