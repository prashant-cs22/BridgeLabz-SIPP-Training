package constructorsAndAccessSpecifiers;

class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 750.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Vehicle Type: " + this.vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistration {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Govind", "Bike");
        Vehicle v2 = new Vehicle("Aryan", "Car");

        System.out.println("Vehicle 1 - ");
        v1.displayVehicleDetails();
        System.out.println();

        System.out.println("Vehicle 2 - ");
        v2.displayVehicleDetails();
        System.out.println();

        Vehicle.updateRegistrationFee(850.0);
        System.out.println("After Updating Registration Fee - ");
        v1.displayVehicleDetails();
    }
}
