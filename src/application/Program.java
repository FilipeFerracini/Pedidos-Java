package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter client data:\n" + "Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);
		System.out.print("Enter order data:\n" + "Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		Date moment = new Date();
		Order order = new Order(moment, status, client);

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.printf("Enter #%d item data:\n" + "Product name: ", i);
			String productName =sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			order.addItem(new OrderItem(productQuantity, productPrice, product));
		}
		
		System.out.println();
		System.out.println(order);

		sc.close();

	}

}
