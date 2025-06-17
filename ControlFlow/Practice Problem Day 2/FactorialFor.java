import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num >= 0) {
            int fact = 1;
            for (int i = 1; i <= num; i++) fact *= i;
            System.out.println("Factorial = " + fact);
        } else {
            System.out.println("Please enter a non-negative number.");
        }
    }
}
