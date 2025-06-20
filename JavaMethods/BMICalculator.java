package JavaMethods;

import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI for each person and update the array
    public static void calculateBMI(double[][] team) {
        for (int i = 0; i < 10; i++) {
            double heightInMeters = team[i][1] / 100.0;
            team[i][2] = team[i][0] / (heightInMeters * heightInMeters);
        }
    }

    // Method to return status string based on BMI
    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] team = new double[10][3]; // weight, height(cm), bmi

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            team[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            team[i][1] = sc.nextDouble();
        }

        calculateBMI(team);

        System.out.println("\nPerson\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            double bmi = team[i][2];
            String status = getStatus(bmi);
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s\n", i + 1, team[i][0], team[i][1], bmi, status);
        }

        sc.close();
    }
}
