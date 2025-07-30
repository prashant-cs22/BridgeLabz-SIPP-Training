package collection;

import java.util.Collections;
import java.util.Map;

public class KeyWithHighestValue {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Input: " + map);

        String maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Output: " + maxKey);
    }
}