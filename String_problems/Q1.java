import java.util.Scanner;

public class Q1 {

    public static void generateException(String input) {
        String sub = input.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    public static void handleException(String input) {
        try {
            String sub = input.substring(5, 2);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        // generateException(userInput);
        handleException(userInput);
    }
}
