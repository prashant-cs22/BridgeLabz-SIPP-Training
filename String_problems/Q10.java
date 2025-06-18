import java.util.Scanner;

public class Q10 {
    static void generateException(String text) {
        int num = Integer.parseInt(text);
    }

    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        generateException(input);
        handleException(input);
    }
}
