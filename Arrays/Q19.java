import java.util.Scanner;

public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight, height;

            while (true) {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Enter a positive value.");
            }

            while (true) {
                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Enter a positive value.");
            }

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n", i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}
