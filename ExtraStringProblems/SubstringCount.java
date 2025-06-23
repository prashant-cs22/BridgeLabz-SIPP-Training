import java.util.Scanner;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter main string:");
        String str = sc.nextLine();
        System.out.println("Enter substring:");
        String sub = sc.nextLine();

        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        System.out.println("Occurrences: " + count);
    }
}
