package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicatesAndPreserveOrder(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4, 1, 5, 4));
        System.out.println("Original List: " + listWithDuplicates);

        List<Integer> listWithoutDuplicates = removeDuplicatesAndPreserveOrder(listWithDuplicates);
        System.out.println("List with Duplicates Removed: " + listWithoutDuplicates);
    }
}