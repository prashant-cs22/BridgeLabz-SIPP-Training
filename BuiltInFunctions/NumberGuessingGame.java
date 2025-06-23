import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1, high = 100;
        Random random = new Random();
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (!correct && low <= high) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "?");
            System.out.print("Enter feedback (low/high/correct): ");
            String feedback = scanner.nextLine();

            if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                correct = true;
                System.out.println("Yay! I guessed your number!");
            } else {
                System.out.println("Invalid input. Please type 'low', 'high' or 'correct'.");
            }
        }
    }

    public static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }
}
