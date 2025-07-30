package collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

    public static Map<String, Integer> countFrequency(List<String> elements) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : elements) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println("Input List: " + input);

        Map<String, Integer> frequency = countFrequency(input);
        System.out.println("Frequency Map: " + frequency);
    }
}