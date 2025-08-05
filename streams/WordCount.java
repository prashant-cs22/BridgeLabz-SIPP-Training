package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WordCount {

    public static void main(String[] args) {
        String filePath = "input.txt";
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by whitespace or punctuation and convert to lowercase
                String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Convert map to a list of entries to sort
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCounts.entrySet());
        
        // Sort the list by value (frequency) in descending order
        sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Display the top 5 most frequent words
        System.out.println("🏆 Top 5 most frequent words:");
        int count = Math.min(5, sortedWords.size());
        for (int i = 0; i < count; i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.printf("%d. '%s' (occurrences: %d)%n", i + 1, entry.getKey(), entry.getValue());
        }
    }
}