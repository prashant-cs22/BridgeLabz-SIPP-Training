import java.util.Scanner;

public class Q15 {
    static String[] splitWords(String text) {
        return text.split(" ");
    }

    static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    static int[] findMinMax(String[] words) {
        int min = getLength(words[0]), max = getLength(words[0]);
        for (String word : words) {
            int len = getLength(word);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = splitWords(input);
        int[] res = findMinMax(words);
        System.out.println("Shortest Length: " + res[0]);
        System.out.println("Longest Length: " + res[1]);
    }
}
