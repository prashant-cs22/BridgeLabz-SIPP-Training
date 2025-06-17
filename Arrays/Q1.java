import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int number : numbers) {
            if (number > 0) {
                if (number % 2 == 0)
                    System.out.println(number + " is positive and even");
                else
                    System.out.println(number + " is positive and odd");
            } else if (number < 0) {
                System.out.println(number + " is negative");
            } else {
                System.out.println("Number is zero");
            }
        }

        if (numbers[0] == numbers[4])
            System.out.println("First and last elements are equal.");
        else if (numbers[0] > numbers[4])
            System.out.println("First element is greater than last.");
        else
            System.out.println("First element is less than last.");
    }
}
