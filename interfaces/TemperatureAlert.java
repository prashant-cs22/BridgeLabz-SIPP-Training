package interfaces;

import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> alert = t -> t > 40;
        System.out.println(alert.test(45.0));
        System.out.println(alert.test(30.0));
    }
}
