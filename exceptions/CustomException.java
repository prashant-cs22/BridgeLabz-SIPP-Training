package exceptions;

import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter your age: ");
            int userAge = scanner.nextInt();

            validateAge(userAge);

            System.out.println("Access granted! You are old enough.");

        } catch (InvalidAgeException e) {
            System.err.println("Access denied: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter a valid integer for age.");
        } finally {
            scanner.close();
        }
    }
}
