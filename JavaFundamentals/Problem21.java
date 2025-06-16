import java.util.Scanner;

public class Problem21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 (meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 (meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 (meters): ");
        double side3 = sc.nextDouble();

        double perimeter = side1 + side2 + side3;
        double distance = 5000; // 5 km in meters
        double rounds = distance / perimeter;

        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km.\n", rounds);
    }
}
