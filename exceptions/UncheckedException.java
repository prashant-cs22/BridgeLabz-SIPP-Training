package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            double result = (double) numerator / denominator;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}
