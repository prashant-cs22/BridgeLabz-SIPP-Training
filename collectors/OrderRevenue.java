package collectors;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Order {
	String customer;
	double amount;
	
	Order(String customer, double amount) {
		this.customer = customer;
		this.amount = amount;
	}
	
	String getCustomer() {
		return this.customer;
	}
	
	double getAmount() {
		return this.amount;
	}
}

public class OrderRevenue {
	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(
	            new Order("A", 100.50),
	            new Order("B", 250.75),
	            new Order("A", 75.25),
	            new Order("C", 300.00),
	            new Order("B", 150.00)
	        );
		
		Map<String, Double> ordersByCustomer = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getAmount))
			);
		System.out.println(ordersByCustomer);
	}
}
