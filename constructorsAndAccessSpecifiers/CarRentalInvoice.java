package constructorsAndAccessSpecifiers;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    private double calculateTotalCost() {
        return this.rentalDays * this.dailyRate;
    }

    void displayDetails() {
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Car Model: " + this.carModel);
        System.out.println("Rental Days: " + this.rentalDays);
        System.out.println("Daily Rate: ₹" + this.dailyRate);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }
}

public class CarRentalInvoice {

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Govind", "Hyundai Creta", 5, 1200);
        CarRental rental2 = new CarRental("Aryan", "Honda City", 3, 1500);

        System.out.println("Rental 1 Details - ");
        rental1.displayDetails();
        System.out.println();

        System.out.println("Rental 2 Details - ");
        rental2.displayDetails();
    }
}
