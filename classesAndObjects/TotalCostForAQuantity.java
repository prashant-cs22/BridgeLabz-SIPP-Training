package classesAndObjects;

class Item {
	int itemCode;
	String itemName;
	double price;
	
	Item(int itemCode, String itemName, double price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}
	
	void displayDetails() {		
		System.out.println("itemCode: " + this.itemCode);
		System.out.println("itemName: " + this.itemName);
		System.out.println("price: " + this.price);
	}
	
	double findPrice(int quantity) {
		return this.price * quantity;
	}
}

public class TotalCostForAQuantity {

	public static void main(String[] args) {
		Item item1 = new Item(1, "Bat", 2000);
		Item item2 = new Item(2, "Ball", 20);
		
		System.out.println("Item 1- ");
		item1.displayDetails();
		System.out.println("Item 2- ");
		item2.displayDetails();
		
//		If i want to buy 10 bats
		double totalPrice = item1.findPrice(10);
		System.out.println("The total price to buy 10 bats is: " + totalPrice);
	}

}
