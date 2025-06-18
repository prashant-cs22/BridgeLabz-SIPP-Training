import java.util.Scanner;

public class Q12 {
    static String[] splitManual(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ') count++;

        String[] words = new String[count];
        String word = "";
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') word += ch;
            else {
                words[index++] = word;
                word = "";
            }
        }
        words[index] = word;
        return words;
    }

    static boolean compare(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] manual = splitManual(input);
        String[] builtIn = input.split(" ");
        System.out.println("Match: " + compare(manual, builtIn));
    }
}
