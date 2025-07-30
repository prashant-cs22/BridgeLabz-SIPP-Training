package collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InsurancePolicyManagementSystemSet {

    private static Set<Policy> hashSetPolicies = new HashSet<>();
    private static Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private static Set<Policy> treeSetPolicies = new TreeSet<>();

    public static void addPolicy(Policy policy) {
        System.out.println("Adding policy: " + policy.getPolicyNumber());
        boolean addedToHashSet = hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
        if (!addedToHashSet) {
            System.out.println("Duplicate policy number " + policy.getPolicyNumber() + ". Not added again.");
        }
    }

    public static void displayAllPolicies(String setName, Set<Policy> policies) {
        System.out.println("\n--- Displaying All Policies from " + setName + " ---");
        policies.forEach(System.out::println);
    }

    public static void displayExpiringSoon(Set<Policy> policies) {
        System.out.println("\n--- Policies Expiring in the Next 30 Days ---");
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        policies.stream()
                .filter(p -> p.getExpiryDate().isBefore(thirtyDaysFromNow) && p.getExpiryDate().isAfter(LocalDate.now()))
                .forEach(System.out::println);
    }

    public static void displayByCoverageType(Set<Policy> policies, String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        policies.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    public static void demonstrateDuplicateHandling() {
        System.out.println("\n--- Demonstrating Duplicate Policy Handling ---");
        Set<Policy> tempSet = new HashSet<>();
        Policy originalPolicy = new Policy(901, "John Doe", LocalDate.of(2025, 1, 1), "Auto", 500);
        Policy duplicatePolicy = new Policy(901, "Jane Smith", LocalDate.of(2026, 1, 1), "Home", 800);
        
        System.out.println("Adding original policy: " + originalPolicy);
        tempSet.add(originalPolicy);
        System.out.println("Attempting to add duplicate policy: " + duplicatePolicy);
        boolean added = tempSet.add(duplicatePolicy);
        System.out.println("Was duplicate added? " + added);
        System.out.println("Final Set: " + tempSet);
    }

    public static void comparePerformance() {
        System.out.println("\n--- Performance Comparison ---");
        List<Policy> policyList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            policyList.add(new Policy(200000 + i, "Perf Test", LocalDate.now().plusYears(1), "Test", 100));
        }
        
        Policy searchPolicy = new Policy(225000, "Perf Test", LocalDate.now().plusYears(1), "Test", 100);
        Policy removePolicy = new Policy(240000, "Perf Test", LocalDate.now().plusYears(1), "Test", 100);

        performSetTest("HashSet", new HashSet<>(), policyList, searchPolicy, removePolicy);
        performSetTest("LinkedHashSet", new LinkedHashSet<>(), policyList, searchPolicy, removePolicy);
        performSetTest("TreeSet", new TreeSet<>(), policyList, searchPolicy, removePolicy);
    }

    private static void performSetTest(String setName, Set<Policy> set, List<Policy> policies, Policy searchKey, Policy removeKey) {
        long startTime, endTime;
        
        startTime = System.nanoTime();
        set.addAll(policies);
        endTime = System.nanoTime();
        System.out.println(setName + " - Add time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        set.contains(searchKey);
        endTime = System.nanoTime();
        System.out.println(setName + " - Search time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        set.remove(removeKey);
        endTime = System.nanoTime();
        System.out.println(setName + " - Remove time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        addPolicy(new Policy(101, "Alice", LocalDate.of(2025, 8, 15), "Health", 1200));
        addPolicy(new Policy(102, "Bob", LocalDate.of(2026, 1, 20), "Auto", 750));
        addPolicy(new Policy(103, "Charlie", LocalDate.now().plusDays(15), "Home", 1500));
        addPolicy(new Policy(104, "David", LocalDate.of(2025, 9, 30), "Health", 1100));
        addPolicy(new Policy(102, "Robert", LocalDate.of(2027, 5, 5), "Life", 2000));
        
        displayAllPolicies("HashSet (Unordered)", hashSetPolicies);
        displayAllPolicies("LinkedHashSet (Insertion Order)", linkedHashSetPolicies);
        displayAllPolicies("TreeSet (Sorted by Expiry Date)", treeSetPolicies);

        displayExpiringSoon(hashSetPolicies);
        displayByCoverageType(hashSetPolicies, "Health");

        demonstrateDuplicateHandling();
        comparePerformance();
    }
}