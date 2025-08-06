package exceptions;

public class ThrowVsThrows {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0 || years < 0) {
            throw new IllegalArgumentException("Amount, rate, and years must be non-negative.");
        }
        return amount * rate * years;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 0.05, 2);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.err.println("Error during calculation: " + e.getMessage());
        }

        System.out.println("\n--------------------------\n");

        try {
            calculateInterest(-500, 0.05, 2);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input provided: " + e.getMessage());
        }
    }
}
