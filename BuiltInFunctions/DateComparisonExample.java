import java.time.LocalDate;
import java.util.Scanner;

public class DateComparisonExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-MM-dd): ");
        String firstDateStr = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateStr);

        System.out.print("Enter second date (yyyy-MM-dd): ");
        String secondDateStr = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateStr);

        if (firstDate.isBefore(secondDate)) {
            System.out.println("First date is before second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("First date is after second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are equal.");
        }
    }
}
