import java.util.Scanner;

public class Q20 {

    static int[] getTrimIndices(String str) {
        int start = 0, end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    static String createSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] indices = getTrimIndices(input);
        String trimmedManual = createSubstring(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Manually Trimmed: '" + trimmedManual + "'");
        System.out.println("Built-in Trimmed: '" + trimmedBuiltIn + "'");
        System.out.println("Are both equal? " + compareStrings(trimmedManual, trimmedBuiltIn));
    }
}
