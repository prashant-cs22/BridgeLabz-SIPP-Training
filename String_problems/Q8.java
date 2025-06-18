import java.util.Scanner;

public class Q8 {
    static char[] toCharArrayManual(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i);
        return arr;
    }

    static boolean compare(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] manual = toCharArrayManual(input);
        char[] builtIn = input.toCharArray();
        System.out.println("Match: " + compare(manual, builtIn));
    }
}
