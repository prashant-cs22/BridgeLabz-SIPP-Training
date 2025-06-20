package JavaMethods;

import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    // Generate random marks for PCM
    public static int[][] generateMarks(int students) {
        Random rand = new Random();
        int[][] marks = new int[students][3];
        for (int i = 0; i < students; i++) {
            marks[i][0] = 40 + rand.nextInt(61); // Physics
            marks[i][1] = 40 + rand.nextInt(61); // Chemistry
            marks[i][2] = 40 + rand.nextInt(61); // Maths
        }
        return marks;
    }

    // Calculate total, average, percentage
    public static double[][] calculateResults(int[][] marks) {
        int n = marks.length;
        double[][] results = new double[n][3]; // [total, average, percentage]

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            results[i][0] = total;
            results[i][1] = total / 3.0;
            results[i][2] = (total / 300.0) * 100;
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] results = calculateResults(marks);

        System.out.println("\nID\tPhy\tChem\tMath\tTotal\tAverage\tPercent");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
        sc.close();
    }
}
