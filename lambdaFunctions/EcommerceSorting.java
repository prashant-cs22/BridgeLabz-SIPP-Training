package lambdaFunctions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Product {
	private String name;
	private double price;
	private double rating;
	private double discount;
	
	public Product(String name, double price, double rating, double discount) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.discount = discount;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getRating() {
		return rating;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%.2f)", name, price);
	}
}

public class EcommerceSorting {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("Laptop", 1200.00, 4.5, 0.10),
				new Product("Mouse", 25.00, 4.8, 0.20), new Product("Keyboard", 75.00, 4.2, 0.05));

		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		System.out.println("Sorted by price: " + products);

		Collections.sort(products, (p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
		System.out.println("Sorted by rating (desc): " + products);

		Collections.sort(products, (p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount()));
		System.out.println("Sorted by discount (desc): " + products);
	}

}