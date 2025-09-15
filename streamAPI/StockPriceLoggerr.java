package streamAPI;

import java.util.Arrays;
import java.util.List;

public class StockPriceLoggerr {
 public static void main(String[] args) {
     List<Double> stockPrices = Arrays.asList(150.25, 151.05, 150.90, 152.10, 151.85);

     stockPrices.forEach(price -> System.out.println("Current stock price: " + price));
 }
}