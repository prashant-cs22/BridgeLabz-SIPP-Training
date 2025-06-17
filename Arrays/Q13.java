import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] service = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Salary: ");
            double sal = sc.nextDouble();

            System.out.print("Years of service: ");
            double yrs = sc.nextDouble();

            if (sal < 0 || yrs < 0) {
                System.out.println("Invalid input. Please re-enter.");
                i--;
                continue;
            }

            salary[i] = sal;
            service[i] = yrs;

            if (service[i] > 5) {
                bonus[i] = 0.05 * salary[i];
            } else {
                bonus[i] = 0.02 * salary[i];
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\n--- Bonus Summary ---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) +
                " | Old Salary: " + salary[i] +
                " | Bonus: " + bonus[i] +
                " | New Salary: " + newSalary[i]);
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}
