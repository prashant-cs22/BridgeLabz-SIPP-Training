import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int original = number, sum = 0;

        while (original != 0) {
            sum += original % 10;
            original /= 10;
        }

        System.out.println(number + (number % sum == 0 ? " is a Harshad Number" : " is not a Harshad Number"));
    }
}
