package collection;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class InsurancePolicyManagementSystemMap {

    public static void main(String[] args) {
        System.out.println("--- Using HashMap (Unordered) ---");
        runDemo(new HashMap<>());

        System.out.println("\n--- Using LinkedHashMap (Insertion Order) ---");
        runDemo(new LinkedHashMap<>());

        System.out.println("\n--- Using TreeMap (Sorted by Key - Policy Number) ---");
        runDemo(new TreeMap<>());
    }
    
    public static void runDemo(Map<Integer, Policy> policies) {
        policies.put(102, new Policy(102, "Bob", LocalDate.of(2026, 1, 20), "Auto", 750));
        policies.put(101, new Policy(101, "Alice", LocalDate.of(2025, 8, 15), "Health", 1200));
        policies.put(104, new Policy(104, "David", LocalDate.now().minusDays(10), "Health", 1100));
        policies.put(103, new Policy(103, "Charlie", LocalDate.now().plusDays(15), "Home", 1500));
        
        System.out.println("All Policies (" + policies.getClass().getSimpleName() + "):");
        policies.values().forEach(p -> System.out.println("  " + p));

        System.out.println("\nRetrieve policy #101: " + policies.get(101));

        listExpiringSoon(policies);
        listByPolicyholder(policies, "Alice");
        
        removeExpiredPolicies(policies);
        System.out.println("\nPolicies after removing expired ones:");
        policies.values().forEach(p -> System.out.println("  " + p));
    }
    
    public static void listExpiringSoon(Map<Integer, Policy> policies) {
        System.out.println("\nPolicies expiring in the next 30 days:");
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        policies.values().stream()
                .filter(p -> p.getExpiryDate().isBefore(thirtyDaysFromNow) && p.getExpiryDate().isAfter(LocalDate.now()))
                .forEach(p -> System.out.println("  " + p));
    }
    
    public static void listByPolicyholder(Map<Integer, Policy> policies, String name) {
        System.out.println("\nPolicies for " + name + ":");
        policies.values().stream()
                .filter(p -> p.getPolicyholderName().equalsIgnoreCase(name))
                .forEach(p -> System.out.println("  " + p));
    }

    public static void removeExpiredPolicies(Map<Integer, Policy> policies) {
        policies.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(LocalDate.now()));
    }
}