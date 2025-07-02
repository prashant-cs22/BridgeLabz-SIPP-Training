package Encapsulation_Polymorphism_InterfaceandAbstractClass;

//RideHailingApp.java

abstract class Vehicle {
	private String vehicleId;
	private String driverName;
	private double ratePerKm;

	public Vehicle(String vehicleId, String driverName, double ratePerKm) {
		this.vehicleId = vehicleId;
		this.driverName = driverName;
		this.ratePerKm = ratePerKm;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getDriverName() {
		return driverName;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public abstract double calculateFare(double distance);

	public void getVehicleDetails() {
		System.out.println(driverName + " driving vehicle " + vehicleId + " at ₹" + ratePerKm + "/km");
	}
}

interface GPS {
	String getCurrentLocation();

	void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
	private String location = "Garage";

	public Car(String id, String name, double rate) {
		super(id, name, rate);
	}

	@Override
	public double calculateFare(double distance) {
		return distance * getRatePerKm();
	}

	@Override
	public String getCurrentLocation() {
		return location;
	}

	@Override
	public void updateLocation(String newLocation) {
		location = newLocation;
	}
}

class Bike extends Vehicle implements GPS {
	private String location = "City Center";

	public Bike(String id, String name, double rate) {
		super(id, name, rate);
	}

	@Override
	public double calculateFare(double distance) {
		return distance * getRatePerKm();
	}

	@Override
	public String getCurrentLocation() {
		return location;
	}

	@Override
	public void updateLocation(String newLocation) {
		location = newLocation;
	}
}

class Auto extends Vehicle implements GPS {
	private String location = "Stand 3";

	public Auto(String id, String name, double rate) {
		super(id, name, rate);
	}

	@Override
	public double calculateFare(double distance) {
		return distance * getRatePerKm() + 10; // Fixed base fare
	}

	@Override
	public String getCurrentLocation() {
		return location;
	}

	@Override
	public void updateLocation(String newLocation) {
		location = newLocation;
	}
}

public class RideHailingApp {
	public static void main(String[] args) {
		Vehicle[] fleet = { new Car("CAR101", "Ravi", 15.0), new Bike("BIKE202", "Seema", 8.0),
				new Auto("AUTO303", "Ram", 10.0) };

		double rideDistance = 12.5;

		for (Vehicle v : fleet) {
			v.getVehicleDetails();
			System.out.println("Fare for " + rideDistance + " km: ₹" + v.calculateFare(rideDistance));

			if (v instanceof GPS gps) {
				System.out.println("Current Location: " + gps.getCurrentLocation());
				gps.updateLocation("Customer Pickup Point");
				System.out.println("Updated Location: " + gps.getCurrentLocation());
			}
			System.out.println("---------------------");
		}
	}
}
