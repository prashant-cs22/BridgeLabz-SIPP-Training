import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter From City: ");
        String fromCity = sc.nextLine();
        System.out.print("Enter Via City: ");
        String viaCity = sc.nextLine();
        System.out.print("Enter To City: ");
        String toCity = sc.nextLine();

        System.out.print("Enter distance from From City to Via City (miles): ");
        double fromToVia = sc.nextDouble();
        System.out.print("Enter distance from Via City to Final City (miles): ");
        double viaToFinalCity = sc.nextDouble();

        System.out.print("Enter time taken from From City to Via City (minutes): ");
        double timeFromToVia = sc.nextDouble();
        System.out.print("Enter time taken from Via City to Final City (minutes): ");
        double timeViaToFinalCity = sc.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity +
                " via " + viaCity + " is " + totalDistance + " miles and the Total Time taken is " + totalTime + " minutes.");
    }
}
