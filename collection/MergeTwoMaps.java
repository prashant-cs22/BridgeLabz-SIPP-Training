package collection;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>(Map.of("A", 1, "B", 2));
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);

        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));

        System.out.println("Output: " + map1);
    }
}