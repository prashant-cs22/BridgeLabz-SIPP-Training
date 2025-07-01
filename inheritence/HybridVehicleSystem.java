package inheritence;

interface Refuelable {
 void refuel(); // Interface behavior
}

class Vehicle {
 protected int maxSpeed;
 protected String model;

 Vehicle(int maxSpeed, String model) {
     this.maxSpeed = maxSpeed;
     this.model = model;
 }

 void displayDetails() {
     System.out.println("Model: " + model);
     System.out.println("Max Speed: " + maxSpeed + " km/h");
 }
}

class ElectricVehicle extends Vehicle {
 private int batteryCapacity; // in kWh

 ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
     super(maxSpeed, model);
     this.batteryCapacity = batteryCapacity;
 }

 void charge() {
     System.out.println(model + " is charging. Battery Capacity: " + batteryCapacity + " kWh.");
 }

 @Override
 void displayDetails() {
     super.displayDetails();
     System.out.println("Vehicle Type: Electric");
     System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
 }
}

class PetrolVehicle extends Vehicle implements Refuelable {
 private int fuelTankCapacity; // in liters

 PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
     super(maxSpeed, model);
     this.fuelTankCapacity = fuelTankCapacity;
 }

 @Override
 public void refuel() {
     System.out.println(model + " is refueling. Tank Capacity: " + fuelTankCapacity + " liters.");
 }

 @Override
 void displayDetails() {
     super.displayDetails();
     System.out.println("Vehicle Type: Petrol");
     System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
 }
}

public class HybridVehicleSystem {
 public static void main(String[] args) {
     ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S", 100);
     PetrolVehicle honda = new PetrolVehicle(180, "Honda City", 45);

     System.out.println("--- Electric Vehicle ---");
     tesla.displayDetails();
     tesla.charge();

     System.out.println("\n--- Petrol Vehicle ---");
     honda.displayDetails();
     honda.refuel();
 }
}
