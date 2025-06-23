import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        System.out.println("Enter character to remove:");
        char remove = sc.next().charAt(0);

        String result = "";
        for (char ch : str.toCharArray()) {
            if (ch != remove) {
                result += ch;
            }
        }

        System.out.println("Modified String: " + result);
    }
}
