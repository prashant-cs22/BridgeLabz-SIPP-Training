import java.util.Scanner;

public class Problem22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary (INR): ");
        double salary = sc.nextDouble();
        System.out.print("Enter bonus (INR): ");
        double bonus = sc.nextDouble();

        double income = salary + bonus;

        System.out.printf("The salary is INR %.2f and the bonus is INR %.2f. Hence Total Income is INR %.2f\n", salary, bonus, income);
    }
}
