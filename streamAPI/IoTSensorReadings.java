package streamAPI;

import java.util.Arrays;
import java.util.List;

public class IoTSensorReadings {
 public static void main(String[] args) {
     List<Double> readings = Arrays.asList(25.5, 28.1, 35.0, 22.9, 40.2, 31.8);
     double threshold = 30.0;

     readings.stream()
         .filter(r -> r > threshold)
         .forEach(r -> System.out.println("High temperature alert: " + r + " degrees."));
 }
}