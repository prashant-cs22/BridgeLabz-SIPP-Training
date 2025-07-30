package collection;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTwoSetsAreEqual {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Set.of(1, 2, 4));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        boolean areEqual12 = set1.equals(set2);
        System.out.println("Set1 and Set2 are equal: " + areEqual12);

        boolean areEqual13 = set1.equals(set3);
        System.out.println("Set1 and Set3 are equal: " + areEqual13);
    }
}