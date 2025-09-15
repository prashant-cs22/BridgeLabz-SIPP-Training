package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
 private String claimType;
 private double amount;

 public Claim(String claimType, double amount) {
     this.claimType = claimType;
     this.amount = amount;
 }

 public String getClaimType() {
     return claimType;
 }

 public double getAmount() {
     return amount;
 }
}

public class InsuranceClaimAnalysis {
 public static void main(String[] args) {
     List<Claim> claims = Arrays.asList(
         new Claim("Medical", 1500.0),
         new Claim("Auto", 5000.0),
         new Claim("Medical", 2500.0),
         new Claim("Home", 10000.0),
         new Claim("Auto", 3000.0),
         new Claim("Medical", 1000.0)
     );

     Map<String, Double> averageClaimAmounts = claims.stream()
         .collect(Collectors.groupingBy(
             Claim::getClaimType,
             Collectors.averagingDouble(Claim::getAmount)
         ));

     averageClaimAmounts.forEach((type, avg) -> System.out.println(type + ": " + avg));
 }
}