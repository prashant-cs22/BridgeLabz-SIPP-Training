import java.util.Scanner;

public class Q11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            physics[i] = getValidMark(sc, "Physics");
            chemistry[i] = getValidMark(sc, "Chemistry");
            maths[i] = getValidMark(sc, "Maths");

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'F';
        }

        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": "
                    + "Physics=" + physics[i] + ", "
                    + "Chemistry=" + chemistry[i] + ", "
                    + "Maths=" + maths[i] + ", "
                    + "Percentage=" + String.format("%.2f", percentage[i]) + "%, "
                    + "Grade=" + grade[i]);
        }

        sc.close();
    }

    public static int getValidMark(Scanner sc, String subject) {
        int mark;
        do {
            System.out.print(subject + " marks (0-100): ");
            mark = sc.nextInt();
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid input. Please enter a value between 0 and 100.");
            }
        } while (mark < 0 || mark > 100);
        return mark;
    }
}
