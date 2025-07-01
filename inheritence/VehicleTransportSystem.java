package inheritence;

class Vehicle {
	int maxSpeed;
	String fuelType;
	
	Vehicle(int maxSpeed, String fuelType) {
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
	}
	
	void displayDetails() {
		System.out.println("Max speed: " + this.maxSpeed + "km/hr");
		System.out.println("Fuel type: " + this.fuelType);
	}
}

class Car extends Vehicle {
	int seatCapacity;
	
	Car(int maxSpeed, String fuelType, int seatCapacity) {
		super(maxSpeed, fuelType);
		this.seatCapacity = seatCapacity;
	}
	
	@Override
	void displayDetails() {
		System.out.println("Type: Car");
		super.displayDetails();
		System.out.println("Seat capacity: " + seatCapacity);
		System.out.println();
	}
}

class Truck extends Vehicle {
	int loadCapacity;
	
	Truck(int maxSpeed, String fuelType, int loadCapacity) {
		super(maxSpeed, fuelType);
		this.loadCapacity = loadCapacity;
	}
	
	@Override
	void displayDetails() {
		System.out.println("Type: Truck");
		super.displayDetails();
		System.out.println("Load capacity: " + loadCapacity + " kg");
		System.out.println();
	}
}

class MotorCycle extends Vehicle {
	int mileage;
	
	public MotorCycle(int maxSpeed, String fuelType, int mileage) {
		super(maxSpeed, fuelType);
		this.mileage = mileage;
	}
	
	@Override
	void displayDetails() {
		System.out.println("Type: MotorCycle");
		super.displayDetails();
		System.out.println("Mileage: " + mileage + " km");
		System.out.println();
	}
}

public class VehicleTransportSystem {

	public static void main(String[] args) {
		Vehicle[] vehicles = {
				new Car(150, "Petrol", 5),
				new Truck(150, "Diesel", 500),
				new MotorCycle(120, "Petrol", 80)
		};
		
		for(Vehicle v: vehicles) {
			v.displayDetails();
		}
	}

}
