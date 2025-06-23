import java.util.Scanner;

public class LexicographicalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter second string:");
        String str2 = sc.nextLine();

        int result = str1.compareTo(str2);
        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
        } else if (result > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\"");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}
