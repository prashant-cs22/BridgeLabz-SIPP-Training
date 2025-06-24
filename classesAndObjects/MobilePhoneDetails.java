package classesAndObjects;

class MobilePhone {
	String brand;
	String model;
	float price;
	
	MobilePhone(String brand, String model, float price){
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	void displayDetails() {
		System.out.println("Brand: " + this.brand);
		System.out.println("Model: " + this.model);
		System.out.println("Price: " + this.price);
	}
}

public class MobilePhoneDetails {

	public static void main(String[] args) {
		MobilePhone phone1 = new MobilePhone("Samsung", "M33", 20000);
		MobilePhone phone2 = new MobilePhone("Samsung", "S25", 60000);
		
		System.out.println("Phone 1-");
		phone1.displayDetails();
		System.out.println("Phone 2-");
		phone2.displayDetails();
	}

}
