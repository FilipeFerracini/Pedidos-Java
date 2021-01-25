package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;

	private List<OrderItem> order = new ArrayList<>();
	private Client client;

	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		order.add(item);
	}

	public void removeItem(OrderItem item) {
		order.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem item : order)
			sum += item.subTotal();
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: " + "\n");

		sb.append("Order moment: ");
		sb.append(sdf1.format(moment) + "\n");

		sb.append("Order status: ");
		sb.append(status + "\n");

		sb.append("Client: " + client.getName());
		sb.append(" (" + sdf2.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail());

		sb.append("Order items: " + "\n");
		for (OrderItem item : order) {
			sb.append(item.getProduct().getName());
			sb.append(", $" + item.getPrice());
			sb.append(", Quantity: " + item.getQuantity());
			sb.append(", Subtotal: ");
			sb.append(String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
