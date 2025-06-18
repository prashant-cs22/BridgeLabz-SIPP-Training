import java.util.Scanner;

public class Q19 {

    static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32); // Convert to lowercase
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] classifyCharacters(String input) {
        int len = input.length();
        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    static void displayResult(String[][] data) {
        System.out.printf("%-10s %-15s\n", "Character", "Type");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[][] result = classifyCharacters(input);
        displayResult(result);
    }
}
