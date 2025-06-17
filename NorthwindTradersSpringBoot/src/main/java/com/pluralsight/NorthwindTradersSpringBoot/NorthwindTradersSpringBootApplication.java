package com.pluralsight.NorthwindTradersSpringBoot;

import dao.ProductDao;
import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;


@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {
		var context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		NorthwindTradersSpringBootApplication app = context.getBean(NorthwindTradersSpringBootApplication.class);
		app.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- PRODUCT MENU ---");
			System.out.println("1. List Products");
			System.out.println("2. Add Product");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			int choice = Integer.parseInt(scanner.nextLine());

			if (choice == 1) {
				productDao.getAll().forEach(System.out::println);
			} else if (choice == 2) {
				System.out.print("Enter ID: ");
				int id = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter category: ");
				String category = scanner.nextLine();
				System.out.print("Enter price: ");
				double price = Double.parseDouble(scanner.nextLine());

				Product product = new Product(id, name, category, price);
				productDao.add(product);
				System.out.println("Product added!");
			} else if (choice == 0) {
				break;
			}
		}

		scanner.close();
	}
}
