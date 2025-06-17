import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number: ");
            double input = sc.nextDouble();
            if (input <= 0 || index == 10) break;
            values[index++] = input;
        }

        for (int i = 0; i < index; i++) {
            total += values[i];
            System.out.println("Value[" + i + "] = " + values[i]);
        }
        System.out.println("Total sum = " + total);
    }
}
