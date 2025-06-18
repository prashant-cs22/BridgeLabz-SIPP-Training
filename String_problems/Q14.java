import java.util.Scanner;

public class Q14 {
    static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = (int) (Math.random() * 100);
        return ages;
    }

    static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = ages[i] >= 18 ? "true" : "false";
        }
        return result;
    }

    static void display(String[][] data) {
        for (String[] row : data) System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = generateAges(n);
        String[][] result = canVote(ages);
        display(result);
    }
}
