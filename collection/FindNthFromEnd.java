package collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FindNthFromEnd {

    public static <T> T findNthElementFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: list cannot be null and n must be positive.");
        }

        var fastPointer = list.listIterator();
        var slowPointer = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (fastPointer.hasNext()) {
                fastPointer.next();
            } else {
                throw new NoSuchElementException("N is larger than the size of the list.");
            }
        }

        while (fastPointer.hasNext()) {
            fastPointer.next();
            slowPointer.next();
        }

        return slowPointer.next(); 
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        System.out.println("LinkedList: " + linkedList);
        int n = 2;
        System.out.println("Finding the " + n + "nd element from the end...");

        try {
            String result = findNthElementFromEnd(linkedList, n);
            System.out.println("Result: " + result); // Output: D
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        n = 5;
        System.out.println("\nFinding the " + n + "th element from the end...");
        try {
            String result = findNthElementFromEnd(linkedList, n);
            System.out.println("Result: " + result); // Output: A
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}