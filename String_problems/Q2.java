import java.util.Scanner;

public class Q2 {

    // Step 2: Method to generate the exception (unhandled)
    static void generateException(String[] names) {
        // Intentionally access invalid index
        System.out.println("Accessing element at index 10: " + names[10]);
    }

    // Step 3: Method to handle exception using try-catch
    static void handleException(String[] names) {
        try {
            System.out.println("Accessing element at index 10: " + names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input array of names
        System.out.print("Enter number of names: ");
        int size = sc.nextInt();
        sc.nextLine(); // Consume newline

        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        // Step 4: Call both methods
        // This will crash the program if not commented, uncomment for testing
        // generateException(names);

        // This will handle the exception gracefully
        handleException(names);
    }
}
