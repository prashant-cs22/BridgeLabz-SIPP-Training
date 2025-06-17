import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int power = sc.nextInt();

        int result = 1;
        int counter = 0;
        while (counter < power) {
            result *= base;
            counter++;
        }

        System.out.println(base + " raised to the power " + power + " = " + result);
    }
}
