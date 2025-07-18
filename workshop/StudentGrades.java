package workshop;

import java.util.*;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students, subjects;

        try {
            System.out.print("Enter number of students: ");
            students = sc.nextInt();
            System.out.print("Enter number of subjects: ");
            subjects = sc.nextInt();

            String[][] studentDetails = new String[students][2];
            int[][] grades = new int[students][subjects];
            boolean[][] isValidGrade = new boolean[students][subjects];

            // Input student details and grades
            for (int i = 0; i < students; i++) {
                sc.nextLine(); // consume leftover newline
                System.out.println("\n--- Student " + (i + 1) + " ---");
                System.out.print("Enter student ID: ");
                studentDetails[i][0] = sc.nextLine();
                System.out.print("Enter student name: ");
                studentDetails[i][1] = sc.nextLine();

                for (int j = 0; j < subjects; j++) {
                    System.out.print("Enter grade for Subject " + (j + 1) + ": ");
                    try {
                        int grade = sc.nextInt();
                        if (grade < 0 || grade > 100) {
                            throw new IllegalArgumentException("Grade must be between 0 and 100");
                        }
                        grades[i][j] = grade;
                        isValidGrade[i][j] = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); // clear invalid input
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            // Total and average per student
            System.out.println("\n--- Student Totals and Averages ---");
            for (int i = 0; i < students; i++) {
                int total = 0, count = 0;
                for (int j = 0; j < subjects; j++) {
                    if (isValidGrade[i][j]) {
                        total += grades[i][j];
                        count++;
                    }
                }
                double avg = count > 0 ? (double) total / count : 0;
                System.out.println(studentDetails[i][1] + " (ID: " + studentDetails[i][0] + ") - Total: " + total + ", Average: " + avg);
            }

            // Highest grade per subject
            System.out.println("\n--- Highest Grade in Each Subject ---");
            for (int j = 0; j < subjects; j++) {
                int max = -1;
                for (int i = 0; i < students; i++) {
                    if (isValidGrade[i][j] && grades[i][j] > max) {
                        max = grades[i][j];
                    }
                }
                System.out.println("Subject " + (j + 1) + ": " + (max >= 0 ? max : "No valid grades"));
            }

            // Overall class average
            int sum = 0, totalGrades = 0;
            for (int i = 0; i < students; i++) {
                for (int j = 0; j < subjects; j++) {
                    if (isValidGrade[i][j]) {
                        sum += grades[i][j];
                        totalGrades++;
                    }
                }
            }
            double classAverage = totalGrades > 0 ? (double) sum / totalGrades : 0;
            System.out.println("\nOverall Class Average: " + classAverage);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        sc.close();
    }
}

