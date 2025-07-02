package Encapsulation_Polymorphism_InterfaceandAbstractClass;
//FoodDeliverySystem.java

abstract class FoodItem {
	private String itemName;
	private double price;
	private int quantity;

	public FoodItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public abstract double calculateTotalPrice();

	public void getItemDetails() {
		System.out.println(itemName + " x " + quantity + " | ₹" + calculateTotalPrice());
	}
}

interface Discountable {
	double applyDiscount();

	String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
	public VegItem(String name, double price, int qty) {
		super(name, price, qty);
	}

	@Override
	public double calculateTotalPrice() {
		return getPrice() * getQuantity() - applyDiscount();
	}

	@Override
	public double applyDiscount() {
		return getPrice() * getQuantity() * 0.10;
	}

	@Override
	public String getDiscountDetails() {
		return "10% discount applied on Veg item";
	}
}

class NonVegItem extends FoodItem implements Discountable {
	public NonVegItem(String name, double price, int qty) {
		super(name, price, qty);
	}

	@Override
	public double calculateTotalPrice() {
		double base = getPrice() * getQuantity();
		double surcharge = base * 0.05; // 5% non-veg surcharge
		return base + surcharge - applyDiscount();
	}

	@Override
	public double applyDiscount() {
		return getPrice() * getQuantity() * 0.08;
	}

	@Override
	public String getDiscountDetails() {
		return "8% discount applied on Non-Veg item (plus 5% surcharge)";
	}
}

public class FoodDeliverySystem {
	public static void main(String[] args) {
		FoodItem[] order = { new VegItem("Paneer Tikka", 180, 2), new NonVegItem("Chicken Biryani", 250, 1) };

		for (FoodItem item : order) {
			item.getItemDetails();
			if (item instanceof Discountable d) {
				System.out.println(d.getDiscountDetails());
			}
			System.out.println("-------------------------");
		}
	}
}
