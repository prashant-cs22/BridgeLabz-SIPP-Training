import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = scanner.nextLine();

        int[] digits = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i) - '0';
        }

        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        scanner.close();
    }
}
