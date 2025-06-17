import java.util.Scanner;

public class Q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");

            double weight, height;

            while (true) {
                System.out.print("Enter weight (kg): ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Please enter a positive weight.");
            }

            while (true) {
                System.out.print("Enter height (m): ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Please enter a positive height.");
            }

            weights[i] = weight;
            heights[i] = height;
            bmis[i] = weight / (height * height);

            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n", i + 1, weights[i], heights[i], bmis[i], statuses[i]);
        }

        sc.close();
    }
}
