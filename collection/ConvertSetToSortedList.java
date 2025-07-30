package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Set.of(5, 3, 9, 1));
        System.out.println("Input Set: " + inputSet);

        List<Integer> sortedList = new ArrayList<>(inputSet);
        Collections.sort(sortedList);

        System.out.println("Output Sorted List: " + sortedList);
    }
}