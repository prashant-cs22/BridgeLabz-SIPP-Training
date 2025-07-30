package collection;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        System.out.println("Input: \"" + text + "\"");

        Map<String, Integer> wordMap = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Output: " + wordMap);
    }
}