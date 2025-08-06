package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter an integer numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter an integer denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } finally {
            System.out.println("--> Operation completed. The 'finally' block has been executed.");
            scanner.close();
        }
    }
}
