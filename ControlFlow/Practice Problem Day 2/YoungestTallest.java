import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter age and height for Amar:");
        int age1 = sc.nextInt(); double h1 = sc.nextDouble();

        System.out.println("Enter age and height for Akbar:");
        int age2 = sc.nextInt(); double h2 = sc.nextDouble();

        System.out.println("Enter age and height for Anthony:");
        int age3 = sc.nextInt(); double h3 = sc.nextDouble();

        // Youngest
        String youngest = (age1 < age2 && age1 < age3) ? "Amar" :
                          (age2 < age3) ? "Akbar" : "Anthony";

        // Tallest
        String tallest = (h1 > h2 && h1 > h3) ? "Amar" :
                         (h2 > h3) ? "Akbar" : "Anthony";

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);
    }
}
