import java.util.Scanner;

public class Q11 {
    static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int manual = getLength(input);
        int builtIn = input.length();
        System.out.println("Manual: " + manual + ", Built-in: " + builtIn);
    }
}
