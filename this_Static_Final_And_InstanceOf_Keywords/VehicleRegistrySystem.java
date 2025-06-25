package this_Static_Final_And_InstanceOf_Keywords;

class Vehicle {
    static double registrationFee = 5000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Fee: " + registrationFee);
        }
    }
}

public class VehicleRegistrySystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("UP16AA1234", "Soham", "Car");
        Vehicle v2 = new Vehicle("UP16BB5678", "Ritu", "Scooter");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
