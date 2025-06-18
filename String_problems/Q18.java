import java.util.Scanner;

public class Q18 {

    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = (int) (Math.random() * 41 + 60); 
            scores[i][1] = (int) (Math.random() * 41 + 60); 
            scores[i][2] = (int) (Math.random() * 41 + 60); 
        }
        return scores;
    }

    static double[][] calculatePerformance(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3]; 
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percent = Math.round((total / 3.0) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percent;
        }
        return result;
    }

    static String[] assignGrades(double[][] performance) {
        int n = performance.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double percent = performance[i][2];
            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] performance, String[] grades) {
        System.out.printf("%-10s %-8s %-8s %-8s %-8s %-10s %-12s %-8s\n", 
            "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s %-8d %-8d %-8d %-8.0f %-10.2f %-12.2f %-8s\n",
                "Student" + (i + 1),
                scores[i][0], scores[i][1], scores[i][2],
                performance[i][0], performance[i][1], performance[i][2],
                grades[i]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] performance = calculatePerformance(scores);
        String[] grades = assignGrades(performance);
        displayScorecard(scores, performance, grades);
    }
}
