package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> order=new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, List<OrderItem> order) {
		this.moment = moment;
		this.status = status;
		this.order = order;
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
		double sum =0;
		for (OrderItem item:order)
			sum+=item.subTotal();
		return sum;
	}

	public String toString() {
		return "Order [moment=" 
				+ moment 
				+ ", status=" 
				+status 
				+ ", order=" 
				+ order 
				+ "]";
	}
	
	
}
