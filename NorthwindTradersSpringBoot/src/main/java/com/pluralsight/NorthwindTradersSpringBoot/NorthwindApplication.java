package com.pluralsight.NorthwindTradersSpringBoot;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. List Products");
			System.out.println("2. Add Product");
			System.out.println("3. Exit");
			System.out.print("Choose option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
				case 1:
					List<Product> products = productDao.getAll();
					products.forEach(System.out::println);
					break;
				case 2:
					System.out.print("Enter product name: ");
					String name = scanner.nextLine();
					System.out.print("Enter category: ");
					String category = scanner.nextLine();
					System.out.print("Enter price: ");
					double price = scanner.nextDouble();
					scanner.nextLine(); // consume newline

					Product product = new Product(0, name, category, price);
					productDao.add(product);
					System.out.println("Product added.");
					break;
				case 3:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice.");
			}
		}
	}
}
