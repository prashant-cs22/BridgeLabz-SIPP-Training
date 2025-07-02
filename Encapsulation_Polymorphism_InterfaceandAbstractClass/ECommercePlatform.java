package Encapsulation_Polymorphism_InterfaceandAbstractClass;

abstract class Product {
	private int productId;
	private String name;
	private double price;

	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		}
	}

	public abstract double calculateDiscount();

	public double calculateFinalPrice() {
		if (this instanceof Taxable) {
			Taxable taxable = (Taxable) this;
			return price + taxable.calculateTax() - calculateDiscount();
		}
		return price - calculateDiscount();
	}

	public void displayDetails() {
		System.out.println("Product: " + name + " | Price: ₹" + price + " | Discount: ₹" + calculateDiscount()
				+ (this instanceof Taxable ? " | Tax: ₹" + ((Taxable) this).calculateTax() : "") + " | Final Price: ₹"
				+ calculateFinalPrice());
	}
}

interface Taxable {
	double calculateTax();

	String getTaxDetails();
}

class Electronics extends Product implements Taxable {
	public Electronics(int id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.1; // 10% discount
	}

	@Override
	public double calculateTax() {
		return getPrice() * 0.18; // 18% GST
	}

	@Override
	public String getTaxDetails() {
		return "Electronics Tax (18%)";
	}
}

class Clothing extends Product implements Taxable {
	public Clothing(int id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.15; // 15% discount
	}

	@Override
	public double calculateTax() {
		return getPrice() * 0.12; // 12% GST
	}

	@Override
	public String getTaxDetails() {
		return "Clothing Tax (12%)";
	}
}

class Groceries extends Product {
	public Groceries(int id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.05; // 5% discount
	}
}

public class ECommercePlatform {
	public static void main(String[] args) {
		Product[] products = { new Electronics(201, "Smartphone", 25000), new Clothing(202, "T-Shirt", 1000),
				new Groceries(203, "Rice (10kg)", 700) };

		for (Product product : products) {
			product.displayDetails();
		}
	}
}
