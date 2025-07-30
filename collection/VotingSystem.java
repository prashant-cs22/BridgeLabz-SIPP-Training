package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {
    public static void main(String[] args) {
        String[] votes = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};

        System.out.println("--- Store votes in HashMap (unordered tally) ---");
        Map<String, Integer> hashMapTally = new HashMap<>();
        for (String candidate : votes) {
            hashMapTally.put(candidate, hashMapTally.getOrDefault(candidate, 0) + 1);
        }
        System.out.println("Final Tally: " + hashMapTally);

        System.out.println("\n--- Use LinkedHashMap to maintain order of first vote ---");
        Map<String, Integer> linkedHashMapTally = new LinkedHashMap<>();
        for (String candidate : votes) {
            linkedHashMapTally.putIfAbsent(candidate, 0);
        }
        System.out.println("Order of candidates as they received first vote: " + linkedHashMapTally.keySet());

        System.out.println("\n--- Use TreeMap to display results in sorted order ---");
        Map<String, Integer> treeMapTally = new TreeMap<>(hashMapTally);
        System.out.println("Sorted Results:");
        treeMapTally.forEach((candidate, count) -> System.out.println(candidate + ": " + count));
    }
}