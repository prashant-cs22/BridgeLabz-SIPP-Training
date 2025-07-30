package collection;

import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> set3 = new HashSet<>(Set.of(2, 5));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        boolean isSubset12 = set2.containsAll(set1);
        System.out.println("Is Set1 a subset of Set2? " + isSubset12);

        boolean isSubset32 = set2.containsAll(set3);
        System.out.println("Is Set3 a subset of Set2? " + isSubset32);
    }
}