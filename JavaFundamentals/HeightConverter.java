
import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = scanner.nextDouble();
        final double CM_TO_INCH = 2.54;
        final int INCHES_IN_FOOT = 12;
        double totalInches = heightCm / CM_TO_INCH;
        int feet = (int) (totalInches / INCHES_IN_FOOT);
        double inches = totalInches % INCHES_IN_FOOT;
        System.out.printf("Your height in cm is %.2f, while in feet is %d and inches is %.2f.%n", heightCm, feet, inches);
        scanner.close();
    }
}