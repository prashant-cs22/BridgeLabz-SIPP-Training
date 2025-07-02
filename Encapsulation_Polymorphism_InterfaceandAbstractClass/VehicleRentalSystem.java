package Encapsulation_Polymorphism_InterfaceandAbstractClass;

//VehicleRentalSystem.java

abstract class Vehicle {
	private String vehicleNumber;
	private String type;
	private double rentalRate;

	public Vehicle(String vehicleNumber, String type, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public abstract double calculateRentalCost(int days);
}

interface Insurable {
	double calculateInsurance();

	String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
	public Car(String num, double rate) {
		super(num, "Car", rate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	@Override
	public double calculateInsurance() {
		return 1500;
	}

	@Override
	public String getInsuranceDetails() {
		return "Basic Car Insurance";
	}
}

class Bike extends Vehicle implements Insurable {
	public Bike(String num, double rate) {
		super(num, "Bike", rate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	@Override
	public double calculateInsurance() {
		return 500;
	}

	@Override
	public String getInsuranceDetails() {
		return "Two-wheeler Insurance";
	}
}

class Truck extends Vehicle implements Insurable {
	public Truck(String num, double rate) {
		super(num, "Truck", rate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days + 1000; // Extra toll charges
	}

	@Override
	public double calculateInsurance() {
		return 3000;
	}

	@Override
	public String getInsuranceDetails() {
		return "Heavy Vehicle Insurance";
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
		Vehicle[] fleet = { new Car("DL1234", 1500), new Bike("UP0912", 500), new Truck("HR3344", 2500) };

		int rentalDays = 5;
		for (Vehicle v : fleet) {
			System.out.println(v.getType() + " [" + v.getVehicleNumber() + "]");
			System.out.println("Rental Cost: ₹" + v.calculateRentalCost(rentalDays));

			if (v instanceof Insurable insurable) {
				System.out.println(
						"Insurance: ₹" + insurable.calculateInsurance() + " (" + insurable.getInsuranceDetails() + ")");
			}
			System.out.println("-------------------------");
		}
	}
}
