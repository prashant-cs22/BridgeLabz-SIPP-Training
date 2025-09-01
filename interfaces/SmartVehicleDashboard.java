package interfaces;

interface Vehicle {
    void displaySpeed();
    default void displayBattery() {}
}

class PetrolCar implements Vehicle {
    public void displaySpeed() { System.out.println("Petrol Car Speed: 80 km/h"); }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() { System.out.println("Electric Car Speed: 100 km/h"); }
    public void displayBattery() { System.out.println("Battery: 85%"); }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle v1 = new PetrolCar();
        Vehicle v2 = new ElectricCar();
        v1.displaySpeed();
        v2.displaySpeed();
        v2.displayBattery();
    }
}
